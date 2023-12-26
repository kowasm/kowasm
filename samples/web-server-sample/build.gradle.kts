plugins {
    kotlin("multiplatform")
}

kotlin {
    wasmJs {
        binaries.executable()
        nodejs()
        applyBinaryen()
    }
    sourceSets {
        val wasmJsMain by getting {
            dependencies {
                implementation(project(":web"))
                implementation(project(":kotlin-html-wasm"))
                implementation(project(":wasi"))
            }
        }
    }
}
