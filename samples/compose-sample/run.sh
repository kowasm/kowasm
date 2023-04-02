#!/usr/bin/env bash

set -e
cd $( cd "$(dirname "${BASH_SOURCE[0]}")" ; pwd -P )

../../gradlew wasmBrowserDistribution
cp build/compileSync/wasm/main/productionExecutable/kotlin/compose-sample-wasm.* build/distributions
python3 -m http.server -d build/distributions