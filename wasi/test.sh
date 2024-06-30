#!/usr/bin/env bash

set -e
cd $( cd "$(dirname "${BASH_SOURCE[0]}")" ; pwd -P )
export NODE_NO_WARNINGS=1

../gradlew clean compileTestProductionExecutableKotlinWasm
node --experimental-wasi-unstable-preview1 $NVM_BIN/mocha -- runner.mjs

