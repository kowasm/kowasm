[!["API documentation"](https://img.shields.io/badge/kowasm.org%2Fapi%2F-green?style=flat&color=d45500&label=API%20documentation)](https://kowasm.org/api/)

!["KoWasm logo](https://avatars.githubusercontent.com/u/122670045?s=200&v=4)

KoWasm explores fullstack development with [Kotlin](https://kotlinlang.org/) and [WebAssembly](https://webassembly.org/). It leverages Kotlin/Wasm, [WASI](https://wasi.dev/) and [WebAssembly Component Model](https://github.com/WebAssembly/component-model).

This project is developed on Sébastien Deleuze's spare time and highly experimental.
It is taking inspiration from [Slava Kuzmich initial prototype](https://github.com/skuzmich/kotlin-wasi-bindings-experiments) with the goal that, at some point, WASI and WebAssembly Component model support would be provided out of the box by Kotlin/Wasm, see [KT-36172](https://youtrack.jetbrains.com/issue/KT-36172) and [KT-56605](https://youtrack.jetbrains.com/issue/KT-56605) related issues.

## Requirements

### Node

Node 22+ should be able to run the project. You can install it using [nvm](https://github.com/nvm-sh/nvm):

```bash
nvm install 22.13.1
npm install --global mocha
```

## Getting started

Use the various `.sh` script to build and test the project. Most of the features can be found in the `samples` directory.

Artifacts are not yet published to any repository, so you need to build them locally. For example:
```bash
./gradlew wasi:publishToMavenLocal
```
