plugins {
    kotlin("multiplatform")
}

kotlin {
    wasmJs {
        binaries.executable()
        browser()
        applyBinaryen()
    }
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":samples:fullstack-sample:common"))
                implementation(project(":effekt-wasm"))
                implementation(project(":kotlin-html-wasm")) // not needed previously, bug?
                implementation(project(":konform-wasm")) // not needed previously, bug?
            }
        }
        val wasmJsMain by getting
    }
}
