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
        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
