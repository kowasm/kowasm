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
                api(project(":core"))
                api(project(":konform-wasm"))
                api(project(":kotlin-html-wasm"))
            }
        }
    }
}

