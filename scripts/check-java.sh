#!/usr/bin/env bash
# check-java.sh
# CSC 151 Java Programming I
#
# Finds all .java files in the repository, compiles each one,
# and reports which files compile successfully and which fail.
#
# Usage:
#   bash scripts/check-java.sh
#
# Requirements:
#   - javac must be installed and on PATH
#   - Run from the repository root directory
#
# Output:
#   PASS or FAIL for each .java file found
#   A summary count at the end

set -euo pipefail

REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
WORK_DIR="$(mktemp -d)"
PASS_COUNT=0
FAIL_COUNT=0
FAIL_LIST=()

# Check that javac is available
if ! command -v javac &> /dev/null; then
    echo "ERROR: javac not found. Install a Java Development Kit (JDK) and add javac to your PATH."
    exit 1
fi

echo "Java compiler: $(javac -version 2>&1)"
echo "Repository root: $REPO_ROOT"
echo "Working directory: $WORK_DIR"
echo ""

# Find all .java files in the repository (excluding .git)
while IFS= read -r -d '' java_file; do
    relative_path="${java_file#"$REPO_ROOT/"}"

    # Copy to temp directory to avoid polluting the source tree with .class files
    cp "$java_file" "$WORK_DIR/"
    filename="$(basename "$java_file")"

    if javac -d "$WORK_DIR" "$WORK_DIR/$filename" 2>/dev/null; then
        echo "PASS  $relative_path"
        PASS_COUNT=$((PASS_COUNT + 1))
    else
        echo "FAIL  $relative_path"
        # Show the compiler error
        javac -d "$WORK_DIR" "$WORK_DIR/$filename" 2>&1 | sed 's/^/      /'
        FAIL_COUNT=$((FAIL_COUNT + 1))
        FAIL_LIST+=("$relative_path")
    fi

    # Clean up compiled class files
    rm -f "$WORK_DIR"/*.class

done < <(find "$REPO_ROOT" -not -path '*/.git/*' -name '*.java' -print0 | sort -z)

echo ""
echo "Results: $PASS_COUNT passed, $FAIL_COUNT failed"

if [ "$FAIL_COUNT" -gt 0 ]; then
    echo ""
    echo "Failed files:"
    for f in "${FAIL_LIST[@]}"; do
        echo "  $f"
    done
    rm -rf "$WORK_DIR"
    exit 1
fi

rm -rf "$WORK_DIR"
echo "All Java files compile successfully."
exit 0
