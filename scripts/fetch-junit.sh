#!/usr/bin/env bash
# fetch-junit.sh
# CSC 151 Java Programming I
#
# Downloads the JUnit console runner into .tools/ so that
# `bash scripts/verify.sh test` can run unit tests.
#
# You run this once per machine or per Codespace. The .tools/ directory is
# ignored by git, so the downloaded file is never committed.
#
# Usage:
#   bash scripts/fetch-junit.sh
#
# ---------------------------------------------------------------------------
# For the instructor maintaining this fork: record the checksum
# ---------------------------------------------------------------------------
#
# JUNIT_SHA256 below is empty. While it is empty, this script checks the
# download against the checksum that Maven Central publishes beside the jar.
# That catches a corrupted download. It does not protect you if Maven Central
# itself serves something unexpected, because both files come from the same
# place.
#
# Record the value once and the check becomes a real pin:
#
#   1. Run this script.
#   2. Copy the SHA-256 value it prints.
#   3. Paste it into JUNIT_SHA256 below.
#   4. Commit the change.
#
# After that, every student and every CI run verifies against the exact file
# you approved.
#
# Working without a network:
#   Download the jar named below on any machine, copy it to
#   .tools/junit-platform-console-standalone.jar, and skip this script.

set -euo pipefail

REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
TOOLS_DIR="$REPO_ROOT/.tools"

# Confirm this version is the one you want before you record its checksum.
JUNIT_VERSION="1.11.4"

# Empty until the instructor records it. See the note above.
JUNIT_SHA256=""

JUNIT_JAR_NAME="junit-platform-console-standalone-${JUNIT_VERSION}.jar"
JUNIT_URL="https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/${JUNIT_VERSION}/${JUNIT_JAR_NAME}"

TARGET="$TOOLS_DIR/junit-platform-console-standalone.jar"

compute_sha256() {
    if command -v sha256sum &> /dev/null; then
        sha256sum "$1" | awk '{print $1}'
    elif command -v shasum &> /dev/null; then
        shasum -a 256 "$1" | awk '{print $1}'
    else
        printf ''
    fi
}

download() {
    local url="$1" out="$2"
    if command -v curl &> /dev/null; then
        curl -fsSL "$url" -o "$out"
    elif command -v wget &> /dev/null; then
        wget -q "$url" -O "$out"
    else
        echo "ERROR: neither curl nor wget is available."
        echo "       Download $url by hand and save it as:"
        echo "         .tools/junit-platform-console-standalone.jar"
        exit 1
    fi
}

if [ -f "$TARGET" ]; then
    echo "The JUnit runner is already installed at .tools/$(basename "$TARGET")."
    echo "SHA-256: $(compute_sha256 "$TARGET")"
    echo ""
    echo "Delete that file and run this script again to reinstall it."
    exit 0
fi

mkdir -p "$TOOLS_DIR"

echo "Downloading JUnit ${JUNIT_VERSION}..."
echo "  from $JUNIT_URL"
echo ""

if ! download "$JUNIT_URL" "$TARGET.part"; then
    rm -f "$TARGET.part"
    echo ""
    echo "ERROR: the download failed."
    echo "       Some networks block Maven Central. If yours does, download the"
    echo "       jar on another machine and copy it to:"
    echo "         .tools/junit-platform-console-standalone.jar"
    exit 1
fi

ACTUAL_SHA="$(compute_sha256 "$TARGET.part")"

if [ -z "$ACTUAL_SHA" ]; then
    rm -f "$TARGET.part"
    echo "ERROR: no SHA-256 tool found (sha256sum or shasum)."
    echo "       This script will not install a file it cannot verify."
    exit 1
fi

if [ -n "$JUNIT_SHA256" ]; then
    # A checksum has been recorded. Enforce it.
    if [ "$ACTUAL_SHA" != "$JUNIT_SHA256" ]; then
        rm -f "$TARGET.part"
        echo "ERROR: the downloaded file does not match the recorded checksum."
        echo "  expected: $JUNIT_SHA256"
        echo "  actual:   $ACTUAL_SHA"
        echo ""
        echo "The file has been deleted. Do not install it."
        echo ""
        echo "If you changed JUNIT_VERSION in this script, update JUNIT_SHA256 too."
        exit 1
    fi
    echo "Checksum verified against the recorded value."
else
    # No checksum recorded yet. Check against the publisher's own file.
    echo "No checksum is recorded in this script."
    echo "Checking the download against the checksum Maven Central publishes..."

    if download "${JUNIT_URL}.sha256" "$TARGET.sha256" 2>/dev/null; then
        PUBLISHED_SHA="$(tr -d '[:space:]' < "$TARGET.sha256" | cut -c1-64)"
        rm -f "$TARGET.sha256"

        if [ "$ACTUAL_SHA" != "$PUBLISHED_SHA" ]; then
            rm -f "$TARGET.part"
            echo ""
            echo "ERROR: the download does not match the published checksum."
            echo "  published: $PUBLISHED_SHA"
            echo "  actual:    $ACTUAL_SHA"
            echo ""
            echo "The file has been deleted. Do not install it."
            exit 1
        fi
        echo "The download matches the published checksum."
    else
        rm -f "$TARGET.sha256"
        echo "WARNING: the published checksum could not be downloaded."
        echo "         The jar was not verified against any external value."
    fi

    echo ""
    echo "-------------------------------------------------------------------"
    echo "Record this value to turn the check into a real pin."
    echo "Edit scripts/fetch-junit.sh and set:"
    echo ""
    echo "  JUNIT_SHA256=\"$ACTUAL_SHA\""
    echo ""
    echo "Then commit the change."
    echo "-------------------------------------------------------------------"
fi

mv "$TARGET.part" "$TARGET"

echo ""
echo "Installed: .tools/$(basename "$TARGET")"
echo "Now run:   bash scripts/verify.sh test"
