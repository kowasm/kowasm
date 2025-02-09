@file:OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)

plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

group = "org.jetbrains.kotlinx"
version = "0.0.8-SNAPSHOT"

kotlin {
    wasmJs {
        nodejs()
    }
    sourceSets {
        val wasmJsMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-browser:0.3")
            }
        }
        val wasmJsTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
