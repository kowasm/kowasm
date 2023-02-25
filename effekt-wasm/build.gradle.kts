plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

kotlin {
    wasm {
        binaries.executable()
        nodejs()
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val wasmMain by getting
        val wasmTest by getting
    }
}
