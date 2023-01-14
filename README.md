KoWasm is an experimental project intended to provide [WASI](https://wasi.dev/) and [WebAssembly Component Model](https://github.com/WebAssembly/component-model) support to [Kotlin](https://kotlinlang.org/)/Wasm.

WASI support is taking inspiration from [Slava Kuzmich initial prototype](https://github.com/skuzmich/kotlin-wasi-bindings-experiments).

## Requirements

Node 20 should be used to run the project. You can install it using [nvm](https://github.com/nvm-sh/nvm):

```bash
NVM_NODEJS_ORG_MIRROR=https://nodejs.org/download/v8-canary nvm install v20.0.0-v8-canary202212266b2b946a63
nvm use v20.0.0-v8-canary202212266b2b946a63
```

## Getting started

To build and test the WASI library:

```bash
wasi/test.sh 
```

To run the WASI sample (current broken with a `wasi.start() has not been called` error):
```bash
samples/wasi-sample/run.sh
```
