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
        val wasmMain by getting
        val wasmTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
