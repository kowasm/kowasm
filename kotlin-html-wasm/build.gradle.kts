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
    wasm {
        browser()
    }
    sourceSets {
        val commonMain by getting
        val wasmMain by getting
    }
}
