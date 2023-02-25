#!/usr/bin/env bash

set -e
cd $( cd "$(dirname "${BASH_SOURCE[0]}")" ; pwd -P )

../../gradlew wasmBrowserDistribution
pwd
cp build/compileSync/wasm/main/productionExecutable/kotlin/kowasm-effekt-sample-wasm.wasm build/distributions/kowasm-effekt-sample-wasm.wasm
python3 -m http.server -d build/distributions