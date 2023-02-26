pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "kowasm"

include("wasi")
include("component-model")
include("effekt-wasm")
include("kotlinx-datetime-wasm")
include("kotlinx-html-wasm")
include("kotlinx-nodejs-wasm")
include("samples:wasi-sample")
include("samples:effekt-sample")
include("samples:http-server-sample")
