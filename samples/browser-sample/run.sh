#!/usr/bin/env bash

set -e
cd $( cd "$(dirname "${BASH_SOURCE[0]}")" ; pwd -P )

../../gradlew wasmBrowserDistribution
pwd
cp build/compileSync/wasm/main/productionExecutable/kotlin/kowasm-browser-sample-wasm.* build/distributions
python3 -m http.server -d build/distributions