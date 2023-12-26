plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

kotlin {
    wasmJs {
        binaries.executable()
        nodejs()
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val wasmJsMain by getting
        val wasmJsTest by getting
    }
}
