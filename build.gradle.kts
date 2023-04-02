
import org.jetbrains.dokka.gradle.DokkaTaskPartial
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin
import org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask

plugins {
    kotlin("multiplatform") version "1.8.20" apply false
    id("org.jetbrains.dokka") version "1.8.10"
}

description = "Fullstack application development with Kotlin and WebAssembly"

allprojects {
    group = "org.kowasm"
    version = "0.1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

rootProject.plugins.withType<NodeJsRootPlugin>(NodeJsRootPlugin::class.java) {
    rootProject.the<NodeJsRootExtension>().apply {
        nodeVersion = "20.0.0-v8-canary20230319df393cb3e4"
        nodeDownloadBaseUrl = "https://nodejs.org/download/v8-canary"
    }
}

tasks.withType<KotlinNpmInstallTask> {
    args.add("--ignore-engines")
}

subprojects {
    tasks.withType<DokkaTaskPartial>().configureEach {
        dokkaSourceSets.configureEach {
            includes.from("README.md")
        }
    }
}