plugins {
    kotlin("multiplatform")
}

group = "org.jetbrains.kotlinx"
version = "0.0.8-SNAPSHOT"

kotlin {
    wasm {
        nodejs()
    }
    sourceSets {
        val wasmMain by getting {
            dependencies {
                implementation(project(":kotlinx-nodejs-wasm"))
            }
        }
        val wasmTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(project(":kotlinx-datetime-wasm"))
                implementation(project(":wasi"))
            }
        }
    }

    // Disabled for now since require custom WASI module configuration, run wasi/test.sh instead.
    tasks.named("wasmNodeTest") {
        enabled = false
    }

}
