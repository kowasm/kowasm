import org.jetbrains.kotlin.gradle.dsl.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

kotlin {
    wasmJs {
        nodejs()
    }
    sourceSets {
        val commonMain by getting
        val wasmJsMain by getting {
            dependencies {
                implementation(project(":wasi"))
            }
        }
        val wasmJsTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }

    tasks.withType<KotlinCompile<*>> {
        kotlinOptions {
            freeCompilerArgs += "-opt-in=kotlin.wasm.unsafe.UnsafeWasmMemoryApi"
            freeCompilerArgs += "-Xexpect-actual-classes"
        }
    }

    // Disabled for now since require custom WASI module configuration, run wasi/test.sh instead.
    tasks.named("wasmJsNodeTest") {
        enabled = false
    }

}
