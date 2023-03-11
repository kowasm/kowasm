plugins {
    kotlin("multiplatform")
    id("org.jetbrains.dokka")
}

kotlin {
    wasm {
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
