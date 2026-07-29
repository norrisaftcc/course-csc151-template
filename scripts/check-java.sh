#!/usr/bin/env bash
# check-java.sh
# CSC 151 Java Programming I
#
# Compiles every .java file in the repository.
#
# This script is kept so that older instructions and older forks keep working.
# It now calls the course verifier, which does more:
#
#   bash scripts/verify.sh compile    compile every .java file (what this does)
#   bash scripts/verify.sh examples   run examples and check their output
#   bash scripts/verify.sh test       run JUnit tests
#   bash scripts/verify.sh all        all of the above
#
# Prefer scripts/verify.sh in new material.

set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
exec bash "$SCRIPT_DIR/verify.sh" compile "$@"
