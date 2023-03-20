plugins {
    kotlin("multiplatform")
    id("maven-publish")
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
    }

}
