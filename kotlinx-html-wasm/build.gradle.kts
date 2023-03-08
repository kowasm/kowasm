import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin

plugins {
    kotlin("multiplatform")
}

group = "org.jetbrains.kotlinx"
version = "0.9.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    wasm {
        browser()
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting
        val wasmMain by getting
    }
}

tasks.register<Task>("generate") {
    group = "source-generation"
    description = "Generate tag-handling code using tags description."

    doLast {
        kotlinx.html.generate.generate(
            "kotlinx.html",
            "src/commonMain/kotlin/generated",
            "src/jsMain/kotlin/generated"
        )
    }
}


infix fun <T> Property<T>.by(value: T) {
    set(value)
}

rootProject.plugins.withType(org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin::class.java) {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension>().ignoreScripts = false
}

rootProject.plugins.withType(NodeJsRootPlugin::class.java) {
    rootProject.the<NodeJsRootExtension>().apply {
        nodeVersion = "20.0.0-v8-canary202212266b2b946a63"
        nodeDownloadBaseUrl = "https://nodejs.org/download/v8-canary"
    }
}