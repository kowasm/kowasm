plugins {
    kotlin("multiplatform")
}

kotlin {
    wasm {
        binaries.executable()
        nodejs()
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
