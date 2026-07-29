#!/usr/bin/env bash
# post-create.sh
# CSC 151 Java Programming I
#
# Runs once when a Codespace or a local dev container is created.
# It installs the JUnit runner and confirms that the environment can
# compile and run Java, so that a student's first check is not a setup failure.

set -uo pipefail

echo "Setting up the CSC 151 environment..."
echo ""

echo "Java version:"
java -version 2>&1 | grep -v '^Picked up ' || true
echo ""

# Install the JUnit runner. A failure here is not fatal: everything except
# `verify.sh test` still works, and the student can rerun the script later.
if bash scripts/fetch-junit.sh; then
    echo ""
else
    echo ""
    echo "WARNING: the JUnit runner could not be installed."
    echo "         Everything except 'bash scripts/verify.sh test' still works."
    echo "         Run 'bash scripts/fetch-junit.sh' again when you have a network."
    echo ""
fi

echo "Checking that the example programs compile and run..."
echo ""
if bash scripts/verify.sh all; then
    echo ""
    echo "-------------------------------------------------------------------"
    echo "Your environment is ready."
    echo ""
    echo "Start here:  modules/m0-getting-on-the-bus/README.md"
    echo ""
    echo "Useful commands:"
    echo "  bash scripts/verify.sh compile    compile every Java file"
    echo "  bash scripts/verify.sh examples   run examples and check their output"
    echo "  bash scripts/verify.sh test       run the unit tests"
    echo "  bash scripts/verify.sh all        all of the above"
    echo "-------------------------------------------------------------------"
else
    echo ""
    echo "-------------------------------------------------------------------"
    echo "Some checks did not pass. Read the FAIL lines above."
    echo "If you have not changed any code yet, tell your instructor:"
    echo "this means the environment, not your work, needs attention."
    echo "-------------------------------------------------------------------"
fi
