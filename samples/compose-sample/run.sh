#!/usr/bin/env bash

set -e
cd $( cd "$(dirname "${BASH_SOURCE[0]}")" ; pwd -P )

../../gradlew :samples:compose-sample:wasmBrowserDistribution
cp build/compileSync/wasm/main/productionExecutable/kotlin/kowasm-compose-sample-wasm.* build/distributions
python3 -m http.server -d build/distributions