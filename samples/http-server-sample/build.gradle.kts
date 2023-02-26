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
                implementation(project(":kotlinx-nodejs-wasm"))
                implementation(project(":kotlinx-html-wasm"))
                implementation(project(":kotlinx-datetime-wasm"))
                implementation(project(":wasi"))
            }
        }
    }
}
