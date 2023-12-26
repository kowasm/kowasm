
import org.jetbrains.dokka.gradle.DokkaTaskPartial
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin

plugins {
    kotlin("multiplatform") version "1.9.22" apply false
    id("org.jetbrains.dokka") version "1.9.10"
}

description = "Fullstack application development with Kotlin and WebAssembly"

allprojects {
    group = "org.kowasm"
    version = "0.1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

rootProject.plugins.withType<NodeJsRootPlugin> {
    rootProject.the<NodeJsRootExtension>().apply {
        nodeVersion = "21.0.0-v8-canary202309143a48826a08"
        nodeDownloadBaseUrl = "https://nodejs.org/download/v8-canary"
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask>().configureEach {
    args.add("--ignore-engines")
}

subprojects {
    tasks.withType<DokkaTaskPartial>().configureEach {
        dokkaSourceSets.configureEach {
            includes.from("README.md")
        }
    }
}