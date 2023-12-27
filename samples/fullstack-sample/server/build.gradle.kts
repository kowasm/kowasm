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
                implementation(project(":samples:fullstack-sample:common"))
                implementation(project(":wasi"))
                implementation(project(":core")) // not needed previously, bug?
                implementation(project(":web"))
                implementation(project(":kotlin-html-wasm"))
            }
        }
    }
}
