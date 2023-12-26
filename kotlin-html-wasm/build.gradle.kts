import org.jetbrains.kotlin.gradle.dsl.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

group = "dev.scottpierce.kotlin-html"
version = "0.2.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    wasmJs {
        browser()
    }
    sourceSets {
        val commonMain by getting
        val wasmJsMain by getting
    }
    tasks.withType<KotlinCompile<*>> {
        kotlinOptions {
            freeCompilerArgs += "-Xexpect-actual-classes"
        }
    }
}
