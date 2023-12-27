plugins {
    kotlin("multiplatform")
}

kotlin {
    wasmJs {
        binaries.executable()
        nodejs()
        applyBinaryen()
    }
    sourceSets {
        val wasmJsMain by getting {
            dependencies {
                implementation(project(":wasi"))
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.5.0")
            }
        }
    }
}
