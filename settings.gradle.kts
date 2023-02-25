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
include("samples:wasi-sample")
include("samples:effekt-sample")
