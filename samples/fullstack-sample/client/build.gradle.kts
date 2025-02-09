@file:OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)

plugins {
    kotlin("multiplatform")
}

kotlin {
    wasmJs {
        binaries.executable()
        browser {
            compilerOptions {
                verbose = true
            }
        }
    }
    sourceSets {
        commonMain {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-browser:0.3")
                implementation(project(":samples:fullstack-sample:common"))
                implementation(project(":effekt-wasm"))
            }
        }
        val wasmJsMain by getting
    }
}
