pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "kowasm"

include("core")
include("wasi")
include("web")
include("component-model")
include("effekt-wasm")
include("konform-wasm")
include("kotlinx-datetime-wasm")
include("kotlinx-html-wasm")
include("kotlinx-nodejs-wasm")
include("samples:wasi-sample")
include("samples:browser-sample")
include("samples:web-server-sample")
include("samples:fullstack-sample:client")
include("samples:fullstack-sample:common")
include("samples:fullstack-sample:server")
