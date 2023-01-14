#!/usr/bin/env bash

set -e
cd $( cd "$(dirname "${BASH_SOURCE[0]}")" ; pwd -P )

../gradlew clean compileTestProductionExecutableKotlinWasm
node --experimental-wasi-unstable-preview1 --experimental-wasm-gc runner.mjs

