@file:OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)

plugins {
    kotlin("multiplatform")
}

kotlin {
    wasmJs {
        binaries.executable()
        nodejs()
    }
    sourceSets {
        val wasmJsMain by getting {
            dependencies {
                implementation(project(":web"))
                implementation(project(":kotlin-html-wasm"))
                implementation(project(":wasi"))
            }
        }
    }
}
