plugins {
    kotlin("multiplatform")
}

kotlin {
    wasm {
        binaries.executable()
        nodejs()
        applyBinaryen()
    }
    sourceSets {
        val wasmMain by getting {
            dependencies {
                implementation(project(":wasi"))
                implementation(project(":kotlinx-datetime-wasm"))
            }
        }
    }
}
