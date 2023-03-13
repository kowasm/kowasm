[!["API documentation](https://img.shields.io/badge/documentation-blue.svg)](https://kowasm.org/api/)

# KoWasm

KoWasm explores fullstack development with [Kotlin](https://kotlinlang.org/) and [WebAssembly](https://webassembly.org/). It leverages Kotlin/Wasm, [WASI](https://wasi.dev/) and [WebAssembly Component Model](https://github.com/WebAssembly/component-model).

This project is developed on Sébastien Deleuze's spare time in collaboration with the Kotlin/Wasm team, taking inspiration from [Slava Kuzmich initial prototype](https://github.com/skuzmich/kotlin-wasi-bindings-experiments) with the goal that, at some point, WASI and WebAssembly Component model support would be provided out of the box by Kotlin/Wasm, see [KT-36172](https://youtrack.jetbrains.com/issue/KT-36172) and [KT-56605](https://youtrack.jetbrains.com/issue/KT-56605) related issues.

**This project and Kotlin/Wasm in general are in very early stage of development:**
 - It leverages Kotlin 1.8.20 APIs and [Node experimental WASI API](https://nodejs.org/api/wasi.html).
 - Artifacts are not published to any repository yet.
 - Pure WASI runtimes like [Wasmtime](https://github.com/bytecodealliance/wasmtime) or [WasmEdge](https://wasmedge.org/) do not support [Wasm garbage collection](https://github.com/WebAssembly/gc) yet, so it is required to use V8-based WASI runtime like Node.  

## Requirements

### IDEA

[IntelliJ IDEA 2023.1 EAP](https://www.jetbrains.com/idea/nextversion/) should be used to get Kotlin/Wasm autocompletion.

### Node

Node 20 should be used (see related [Node WASI documentation](https://nodejs.org/api/wasi.html)) to run the project due to constraints related to [Wasm GC](https://github.com/WebAssembly/gc). You can install it using [nvm](https://github.com/nvm-sh/nvm):

```bash
NVM_NODEJS_ORG_MIRROR=https://nodejs.org/download/v8-canary nvm install v20.0.0-v8-canary202212266b2b946a63
nvm use v20.0.0-v8-canary202212266b2b946a63
npm install --global mocha
```

## Getting started

Use the various `.sh` script to build and test the project. Most of the features can be found in the `samples` directory.

Artifacts are not yet published to any repository, so you need to build them locally. For example:
```bash
./gradlew wasi:publishToMavenLocal
```
