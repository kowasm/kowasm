plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

group = "io.konform"
version = "0.5.0-SNAPSHOT"

kotlin {
    wasm {
        browser()
        nodejs()
    }
    sourceSets {
        val commonMain by getting
        val wasmMain by getting
    }
}
