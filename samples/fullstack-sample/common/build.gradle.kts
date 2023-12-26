plugins {
    kotlin("multiplatform")
}

kotlin {
    wasmJs {
        nodejs()
    }
    sourceSets {
        val wasmJsMain by getting {
            dependencies {
                implementation(project(":konform-wasm"))
                implementation(project(":kotlin-html-wasm"))
            }
        }
    }
}

