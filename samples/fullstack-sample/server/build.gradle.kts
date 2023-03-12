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
                implementation(project(":samples:fullstack-sample:common"))
                implementation(project(":web"))
                implementation(project(":kotlinx-html-wasm"))
            }
        }
    }
}
