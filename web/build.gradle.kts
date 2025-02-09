@file:OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)

plugins {
    kotlin("multiplatform")
    id("maven-publish")
    id("org.jetbrains.dokka")
}

kotlin {
    wasmJs {
        nodejs()
    }
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":core"))
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val wasmJsMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-browser:0.3")
                implementation(project(":kotlinx-nodejs-wasm"))
            }
        }
    }

}
