@file:OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)

plugins {
    kotlin("multiplatform")
}

kotlin {
    wasmJs {
        nodejs()
    }
    sourceSets {
        val wasmJsMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-browser:0.3")
                api(project(":core"))
                api("io.konform:konform:0.10.0")
                api(project(":kotlin-html-wasm"))
            }
        }
    }
}

