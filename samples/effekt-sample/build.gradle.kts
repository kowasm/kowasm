plugins {
    kotlin("multiplatform")
}

kotlin {
    wasm {
        binaries.executable()
        browser()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":effekt-wasm"))
                implementation(project(":kotlinx-html-wasm"))
            }

        }
        val wasmMain by getting {
            dependencies {
                implementation(project(":effekt-wasm"))
            }
        }
    }

}
