plugins {
    kotlin("multiplatform")
}

kotlin {
    wasmJs {
        binaries.executable()
        browser()
    }
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":samples:fullstack-sample:common"))
                implementation(project(":effekt-wasm"))
            }
        }
        val wasmJsMain by getting
    }
}
