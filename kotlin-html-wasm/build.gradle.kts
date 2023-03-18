import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin

plugins {
    kotlin("multiplatform")
}

group = "dev.scottpierce.kotlin-html"
version = "0.2.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    wasm {
        browser()
    }
    sourceSets {
        val commonMain by getting
        val wasmMain by getting
    }
}

rootProject.plugins.withType(NodeJsRootPlugin::class.java) {
    rootProject.the<NodeJsRootExtension>().apply {
        nodeVersion = "20.0.0-v8-canary202212266b2b946a63"
        nodeDownloadBaseUrl = "https://nodejs.org/download/v8-canary"
    }
}