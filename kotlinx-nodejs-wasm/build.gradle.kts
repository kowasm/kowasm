import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

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
        val wasmJsMain by getting
        val wasmJsTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
