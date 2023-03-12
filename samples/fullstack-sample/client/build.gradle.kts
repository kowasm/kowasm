plugins {
    kotlin("multiplatform")
}

kotlin {
    wasm {
        binaries.executable()
        browser()
        applyBinaryen()
    }
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":samples:fullstack-sample:common"))
                implementation(project(":effekt-wasm"))
            }
        }
        val wasmMain by getting
    }
}

// See https://youtrack.jetbrains.com/issue/KT-57203 related issue
tasks.named("wasmDevelopmentExecutableCompileSync") {
    dependsOn("wasmBrowserProductionWebpack")
}
