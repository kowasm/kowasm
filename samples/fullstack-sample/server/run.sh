#!/usr/bin/env bash

set -e
cd $( cd "$(dirname "${BASH_SOURCE[0]}")" ; pwd -P )
export NODE_NO_WARNINGS=1

../../../gradlew clean compileProductionExecutableKotlinWasm
echo ""
echo "Running fullstack server"
echo ""
node --experimental-wasi-unstable-preview1 --experimental-wasm-gc runner.mjs
