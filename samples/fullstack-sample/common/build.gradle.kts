plugins {
    kotlin("multiplatform")
}

kotlin {
    wasm {
        nodejs()
    }
    sourceSets {
        val wasmMain by getting {
            dependencies {
                implementation(project(":konform-wasm"))
                implementation(project(":kotlinx-html-wasm"))
            }
        }
    }
}

