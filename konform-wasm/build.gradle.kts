plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

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
