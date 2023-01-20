# KoWasm

KoWasm is an experimental project intended to provide [WASI](https://wasi.dev/) and [WebAssembly Component Model](https://github.com/WebAssembly/component-model) support for [Kotlin](https://kotlinlang.org/)/Wasm to develop server-side and full stack applications.

WASI support is developed on my spare time in collaboration with the Kotlin/Wasm team, taking inspiration from [Slava Kuzmich initial prototype](https://github.com/skuzmich/kotlin-wasi-bindings-experiments) and with the goal that at some point, WASI support would be provided out of the box by Kotlin/Wasm. See [KT-36172](https://youtrack.jetbrains.com/issue/KT-36172) related issue.

**This project and Kotlin/Wasm in general are in very early stage of development:**
 - It leverages Kotlin 1.8.20 snapshot APIs and [Node experimental WASI API](https://nodejs.org/api/wasi.html).
 - Autocompletion is not working yet.
 - Artifacts are not published to any repository yet.
 - Pure WASI runtimes like [Wasmtime](https://github.com/bytecodealliance/wasmtime) do not support [Wasm garbage collection](https://github.com/WebAssembly/gc) yet, so it is required to use V8-based WASI runtime like Node (see related WASI doc).  

## Requirements

### IDEA

[IntelliJ IDEA 2023.1 EAP](https://www.jetbrains.com/idea/nextversion/) should be used to get Kotlin/Wasm autocompletion.

### Node

Node 20 should be used (see related [Node WASI documentation](https://nodejs.org/api/wasi.html)) to run the project due to constraints related to [Wasm GC](https://github.com/WebAssembly/gc). You can install it using [nvm](https://github.com/nvm-sh/nvm):

```bash
NVM_NODEJS_ORG_MIRROR=https://nodejs.org/download/v8-canary nvm install v20.0.0-v8-canary202212266b2b946a63
nvm use v20.0.0-v8-canary202212266b2b946a63
```

## Getting started

To build and test the WASI library:

```bash
wasi/test.sh 
```

To run the WASI sample:
```bash
samples/wasi-sample/run.sh
```

Artifacts are not yet published to any repository, so you need to build them locally:
```bash
./gradlew wasi:publishToMavenLocal
```

## Documentation

[Dokka does not support yet Kotlin/Wasm](https://github.com/Kotlin/dokka/issues/2814) but you can see the WASI Kotlin public API [here](https://github.com/sdeleuze/kowasm/blob/main/wasi/src/wasmMain/kotlin/org/kowasm/wasi/).
