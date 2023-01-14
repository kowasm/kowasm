#!/usr/bin/env bash

set -e
cd $( cd "$(dirname "${BASH_SOURCE[0]}")" ; pwd -P )

set -ex

../../gradlew clean compileProductionExecutableKotlinWasm
node --experimental-wasi-unstable-preview1 --experimental-wasm-gc runner.mjs
