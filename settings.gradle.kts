pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
        maven("https://packages.jetbrains.team/maven/p/karpovich-sandbox/ksandbox")
    }
}

rootProject.name = "kowasm"

include("core")
include("wasi")
include("web")
include("component-model")
include("effekt-wasm")
include("konform-wasm")
include("kotlin-html-wasm")
include("kotlinx-datetime-wasm")
include("kotlinx-nodejs-wasm")
include("samples:wasi-sample")
include("samples:browser-sample")
include("samples:compose-sample")
include("samples:web-server-sample")
include("samples:fullstack-sample:client")
include("samples:fullstack-sample:common")
include("samples:fullstack-sample:server")
