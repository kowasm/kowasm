import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin

plugins {
    kotlin("multiplatform") version "1.8.20-RC" apply false
    id("org.jetbrains.dokka") version "1.8.10" apply false
}

allprojects {
    group = "org.kowasm"
    version = "0.1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

rootProject.plugins.withType<NodeJsRootPlugin>(NodeJsRootPlugin::class.java) {
    rootProject.the<NodeJsRootExtension>().apply {
        nodeVersion = "20.0.0-v8-canary202212266b2b946a63"
        nodeDownloadBaseUrl = "https://nodejs.org/download/v8-canary"
    }
}
