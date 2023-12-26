plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

group = "io.konform"
version = "0.5.0-SNAPSHOT"

kotlin {
    wasmJs {
        browser()
        nodejs()
    }
    sourceSets {
        val commonMain by getting
        val wasmJsMain by getting
    }
}
