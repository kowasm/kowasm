import org.jetbrains.kotlin.gradle.dsl.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

kotlin {
    wasm {
        nodejs()
    }
    // Temporary workaround for https://youtrack.jetbrains.com/issue/KTIJ-23644/IDEA-doesnt-import-properly-wasm-sourcesets
    js(IR) {
        nodejs()
    }
    sourceSets {
        val wasmMain by getting
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
