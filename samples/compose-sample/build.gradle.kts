plugins {
	kotlin("multiplatform") version "1.9.21"
	id("org.jetbrains.compose") version "1.5.11"
}

repositories {
	repositories {
		google()
		mavenCentral()
	}
}

kotlin {
	wasmJs {
		browser()
		binaries.executable()
		applyBinaryen()
	}
	sourceSets {
		val wasmJsMain by getting {
			dependencies {
				implementation(compose.web.core)
				implementation(compose.runtime)
			}
		}
	}
}
