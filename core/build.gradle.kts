plugins {
    kotlin("multiplatform")
    id("org.jetbrains.dokka")
}

kotlin {
    wasm {
        nodejs()
    }
    sourceSets {
        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
