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
                implementation(project(":wasi"))
                implementation(project(":kotlinx-datetime-wasm"))
            }
        }
    }
}
