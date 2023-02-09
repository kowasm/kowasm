pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "kowasm"

include("wasi")
include("component-model")
include("kotlinx-datetime-wasm")
include("samples:wasi-sample")
