plugins {
    kotlin("multiplatform") version "1.8.20-Beta"
}

group = "org.jetbrains.kotlinx"
version = "0.0.8-SNAPSHOT"

kotlin {
    wasm {
        nodejs()
    }
    sourceSets {
        val wasmMain by getting {
            dependencies {
                implementation(project(":kotlinx-nodejs-wasm"))
            }
        }
        val wasmTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(project(":kotlinx-datetime-wasm"))
                implementation(project(":wasi"))
            }
        }
    }
}
