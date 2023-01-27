import org.jetbrains.kotlin.gradle.dsl.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

kotlin {
    wasm {
        nodejs()
    }
    sourceSets {
        val wasmMain by getting {
            dependencies {
                implementation(project(":wasi"))
            }
        }
        val wasmTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }

    tasks.withType<KotlinCompile<*>> {
        kotlinOptions {
            freeCompilerArgs += "-opt-in=kotlin.wasm.unsafe.UnsafeWasmMemoryApi"
        }
    }

    // Disabled for now since require custom WASI module configuration, run wasi/test.sh instead.
    tasks.named("wasmNodeTest") {
        enabled = false
    }

}
