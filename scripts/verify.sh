#!/usr/bin/env bash
# verify.sh
# CSC 151 Java Programming I
#
# The course verifier. Compiles Java files, runs examples and compares their
# output against a recorded expectation, and runs JUnit tests.
#
# Usage:
#   bash scripts/verify.sh compile  [path]   Compile every .java file
#   bash scripts/verify.sh run      <file>   Compile one file, run it, diff its output
#   bash scripts/verify.sh examples [path]   Run every example that has a .expected file
#   bash scripts/verify.sh test     [path]   Run JUnit tests
#   bash scripts/verify.sh all                Everything above
#
# If you give no path, the verifier checks the whole repository.
#
# Fixture files sit next to the example they belong to:
#
#   examples/ArrayMax.java       the program
#   examples/ArrayMax.expected   the exact output the program must print
#   examples/ArrayMax.stdin      optional. Input fed to the program.
#
# Requirements:
#   javac and java must be on your PATH.
#   JUnit tests also need scripts/fetch-junit.sh to have run once.
#
# Output:
#   PASS or FAIL for each check, then a summary count.
#   Exit code 0 when everything passes, 1 when anything fails.

set -euo pipefail

REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
TOOLS_DIR="$REPO_ROOT/.tools"
JUNIT_JAR="$TOOLS_DIR/junit-platform-console-standalone.jar"

PASS_COUNT=0
FAIL_COUNT=0
WARN_COUNT=0
FAIL_LIST=()

# Every temporary directory this run creates, removed on exit.
WORK_DIRS=()
cleanup() {
    for d in ${WORK_DIRS[@]+"${WORK_DIRS[@]}"}; do
        rm -rf "$d"
    done
}
trap cleanup EXIT

new_work_dir() {
    local d
    d="$(mktemp -d)"
    WORK_DIRS+=("$d")
    printf '%s' "$d"
}

pass() {
    echo "PASS  $1"
    PASS_COUNT=$((PASS_COUNT + 1))
}

fail() {
    echo "FAIL  $1"
    FAIL_COUNT=$((FAIL_COUNT + 1))
    FAIL_LIST+=("$1")
}

warn() {
    echo "WARN  $1"
    WARN_COUNT=$((WARN_COUNT + 1))
}

# Prints compiler or runtime messages so a student can act on them.
#   - Rewrites the temporary build path back to the file's real path, so an
#     error points at a file the student can actually open.
#   - Drops the JVM's "Picked up ..." notices, which are set by the
#     environment and say nothing about the student's code.
show_diagnostics() {
    local msg_file="$1" work_dir="$2" real_file="$3"
    grep -v '^Picked up [A-Z_]*JAVA[A-Z_]*OPTIONS:' "$msg_file" \
        | sed "s#$work_dir/$(basename "$real_file")#$(relative_path "$real_file")#g" \
        | sed "s#$work_dir/##g" \
        | sed 's/^/      /'
}

require_javac() {
    if ! command -v javac &> /dev/null; then
        echo "ERROR: javac not found. Install a Java Development Kit (JDK) and add javac to your PATH."
        exit 1
    fi
}

require_java() {
    if ! command -v java &> /dev/null; then
        echo "ERROR: java not found. Install a Java Development Kit (JDK) and add java to your PATH."
        exit 1
    fi
}

# Prints the path each .java file should be reported under.
relative_path() {
    printf '%s' "${1#"$REPO_ROOT/"}"
}

# ---------------------------------------------------------------------------
# compile — every .java file must compile on its own
# ---------------------------------------------------------------------------

cmd_compile() {
    local search_root="${1:-$REPO_ROOT}"
    require_javac

    echo "Java compiler: $(javac -version 2>&1)"
    echo "Compiling every .java file under: $(relative_path "$search_root")"
    echo ""

    local work_dir
    work_dir="$(new_work_dir)"

    local java_file rel filename
    while IFS= read -r -d '' java_file; do
        rel="$(relative_path "$java_file")"
        filename="$(basename "$java_file")"

        # Copy to a temp directory so .class files never touch the source tree.
        cp "$java_file" "$work_dir/"

        if javac -d "$work_dir" "$work_dir/$filename" 2> "$work_dir/javac.err"; then
            pass "$rel"
        else
            fail "$rel"
            show_diagnostics "$work_dir/javac.err" "$work_dir" "$java_file"
        fi

        rm -f "$work_dir"/*.class
        # Files under tests/ are skipped here: they need the JUnit runner on
        # the classpath, so `verify.sh test` compiles them instead.
    done < <(find "$search_root" -not -path '*/.git/*' -not -path '*/.tools/*' -not -path '*/tests/*' -name '*.java' -print0 | sort -z)
}

# ---------------------------------------------------------------------------
# run — compile one file, run it, compare output against its .expected file
# ---------------------------------------------------------------------------

run_one() {
    local java_file="$1"
    local rel expected_file stdin_file work_dir filename classname
    rel="$(relative_path "$java_file")"
    expected_file="${java_file%.java}.expected"
    stdin_file="${java_file%.java}.stdin"
    filename="$(basename "$java_file")"
    classname="${filename%.java}"

    if [ ! -f "$expected_file" ]; then
        echo "ERROR: no expectation file for $rel"
        echo "       Create $(relative_path "$expected_file") holding the exact output the program prints."
        return 1
    fi

    work_dir="$(new_work_dir)"
    cp "$java_file" "$work_dir/"

    if ! javac -d "$work_dir" "$work_dir/$filename" 2> "$work_dir/javac.err"; then
        fail "$rel (did not compile)"
        show_diagnostics "$work_dir/javac.err" "$work_dir" "$java_file"
        return 1
    fi

    # The expectation covers standard output only. Standard error is kept
    # separate so that JVM notices and stack traces never corrupt the diff.
    # Feed the .stdin fixture when there is one, otherwise nothing.
    local exit_status=0
    if [ -f "$stdin_file" ]; then
        java -cp "$work_dir" "$classname" < "$stdin_file" > "$work_dir/actual" 2> "$work_dir/stderr" || exit_status=$?
    else
        java -cp "$work_dir" "$classname" < /dev/null > "$work_dir/actual" 2> "$work_dir/stderr" || exit_status=$?
    fi

    if [ "$exit_status" -ne 0 ]; then
        fail "$rel (exited with status $exit_status)"
        show_diagnostics "$work_dir/stderr" "$work_dir" "$java_file"
        return 1
    fi

    if diff -u "$expected_file" "$work_dir/actual" > "$work_dir/diff.txt"; then
        pass "$rel"
        return 0
    fi

    fail "$rel (output did not match expectation)"
    echo "      --- expected, +++ actual"
    sed '1,2d; s/^/      /' "$work_dir/diff.txt"
    return 1
}

cmd_run() {
    local target="${1:-}"
    if [ -z "$target" ]; then
        echo "ERROR: 'run' needs a file. Example: bash scripts/verify.sh run modules/m6-arrays-collections/examples/ArrayMax.java"
        exit 1
    fi
    if [ ! -f "$target" ]; then
        echo "ERROR: no such file: $target"
        exit 1
    fi
    require_javac
    require_java
    run_one "$(cd "$(dirname "$target")" && pwd)/$(basename "$target")" || true
}

# ---------------------------------------------------------------------------
# examples — run every example that has a .expected file
# ---------------------------------------------------------------------------

cmd_examples() {
    local search_root="${1:-$REPO_ROOT}"
    require_javac
    require_java

    echo "Running every example with a recorded expectation under: $(relative_path "$search_root")"
    echo ""

    local java_file rel found=0
    while IFS= read -r -d '' java_file; do
        if [ -f "${java_file%.java}.expected" ]; then
            found=1
            run_one "$java_file" || true
        elif grep -q '^// Expected output:' "$java_file" 2>/dev/null; then
            # The file documents its output but nothing checks it yet.
            rel="$(relative_path "$java_file")"
            warn "$rel documents its output in a comment but has no .expected file"
        fi
    done < <(find "$search_root" -not -path '*/.git/*' -not -path '*/.tools/*' -not -path '*/tests/*' -name '*.java' -print0 | sort -z)

    if [ "$found" -eq 0 ]; then
        echo "No examples with a .expected file were found."
    fi
}

# ---------------------------------------------------------------------------
# test — JUnit
# ---------------------------------------------------------------------------

cmd_test() {
    local search_root="${1:-$REPO_ROOT}"
    require_javac
    require_java

    if [ ! -f "$JUNIT_JAR" ]; then
        if [ "${JUNIT_OPTIONAL:-0}" = "1" ]; then
            # Reached from `all`. Say so and carry on, so that a student who
            # has not installed the runner still gets the other checks.
            warn "JUnit tests skipped: the runner is not installed (run: bash scripts/fetch-junit.sh)"
            return 0
        fi
        echo "ERROR: the JUnit runner is not installed."
        echo "       Run this once, then try again:"
        echo ""
        echo "         bash scripts/fetch-junit.sh"
        echo ""
        exit 1
    fi

    # A tests directory holds the tests. The sibling examples directory holds
    # the code under test.
    local test_dirs=()
    while IFS= read -r -d '' d; do
        test_dirs+=("$d")
    done < <(find "$search_root" -not -path '*/.git/*' -type d -name tests -print0 | sort -z)

    if [ "${#test_dirs[@]}" -eq 0 ]; then
        echo "No tests/ directories found under $(relative_path "$search_root")."
        echo "Nothing to test."
        return 0
    fi

    local test_dir rel module_dir work_dir
    for test_dir in "${test_dirs[@]}"; do
        rel="$(relative_path "$test_dir")"
        module_dir="$(dirname "$test_dir")"
        work_dir="$(new_work_dir)"

        # Compile the module's examples and its tests together.
        local sources=()
        while IFS= read -r -d '' f; do sources+=("$f"); done \
            < <(find "$module_dir/examples" "$test_dir" -name '*.java' -print0 2>/dev/null | sort -z)

        if [ "${#sources[@]}" -eq 0 ]; then
            warn "$rel contains no .java files"
            continue
        fi

        if ! javac -cp "$JUNIT_JAR" -d "$work_dir" "${sources[@]}" 2> "$work_dir/javac.err"; then
            fail "$rel (tests did not compile)"
            show_diagnostics "$work_dir/javac.err" "$work_dir" "$test_dir"
            continue
        fi

        if java -jar "$JUNIT_JAR" execute \
                --class-path "$work_dir" \
                --scan-class-path \
                --details=summary \
                --disable-ansi-colors \
                > "$work_dir/junit.out" 2>&1; then
            pass "$rel"
            sed -n '/tests successful/p; /tests failed/p' "$work_dir/junit.out" | sed 's/^/      /'
        else
            fail "$rel"
            show_diagnostics "$work_dir/junit.out" "$work_dir" "$test_dir"
        fi
    done
}

# ---------------------------------------------------------------------------
# summary and dispatch
# ---------------------------------------------------------------------------

print_summary() {
    echo ""
    if [ "$WARN_COUNT" -gt 0 ]; then
        echo "Results: $PASS_COUNT passed, $FAIL_COUNT failed, $WARN_COUNT warned"
    else
        echo "Results: $PASS_COUNT passed, $FAIL_COUNT failed"
    fi

    if [ "$FAIL_COUNT" -gt 0 ]; then
        echo ""
        echo "Failed:"
        local f
        for f in "${FAIL_LIST[@]}"; do
            echo "  $f"
        done
        exit 1
    fi

    echo "Everything checked passed."
}

usage() {
    sed -n '2,30p' "${BASH_SOURCE[0]}" | sed 's|^# \{0,1\}||'
}

main() {
    local subcommand="${1:-}"
    shift || true

    case "$subcommand" in
        compile)  cmd_compile "$@" ;;
        run)      cmd_run "$@" ;;
        examples) cmd_examples "$@" ;;
        test)     cmd_test "$@" ;;
        all)
            cmd_compile
            echo ""
            echo "---"
            echo ""
            cmd_examples
            echo ""
            echo "---"
            echo ""
            JUNIT_OPTIONAL=1 cmd_test
            ;;
        ""|-h|--help|help)
            usage
            exit 0
            ;;
        *)
            echo "ERROR: unknown subcommand: $subcommand"
            echo ""
            usage
            exit 1
            ;;
    esac

    print_summary
}

main "$@"
