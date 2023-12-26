import org.jetbrains.kotlin.gradle.dsl.KotlinCompile


plugins {
    kotlin("multiplatform")
}

kotlin {
    wasmJs {
        nodejs()
    }
    sourceSets {
        val wasmJsTest by getting {
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
    tasks.named("wasmJsNodeTest") {
        enabled = false
    }

}
