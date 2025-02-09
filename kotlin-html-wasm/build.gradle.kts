@file:OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)

plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

group = "dev.scottpierce.kotlin-html"
version = "0.2.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    wasmJs {
        browser()
    }
    sourceSets {
        val commonMain by getting
        val wasmJsMain by getting
    }
    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
}
