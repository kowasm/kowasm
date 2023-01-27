pluginManagement {
    repositories {
        maven(url = "https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
        mavenCentral()
    }
}

rootProject.name = "kowasm"

include("wasi")
include("kotlinx-datetime-wasm")
include("samples:wasi-sample")
