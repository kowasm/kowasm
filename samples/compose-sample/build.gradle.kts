plugins {
	kotlin("multiplatform") version "1.8.20-RC"
	id("org.jetbrains.compose") version "1.4.0-dev-wasm01"
}

repositories {
	repositories {
		google()
		mavenCentral()
		maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
		maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
		maven("https://packages.jetbrains.team/maven/p/karpovich-sandbox/ksandbox")
	}
}

kotlin {
	wasm {
		browser()
		binaries.executable()
		applyBinaryen()
	}
	sourceSets {
		val wasmMain by getting {
			dependencies {
				implementation(compose.web.core)
				implementation(compose.runtime)
			}
		}
	}
}

// See https://youtrack.jetbrains.com/issue/KT-57203 related issue
tasks.named("wasmDevelopmentExecutableCompileSync") {
	dependsOn("wasmBrowserProductionWebpack")
}
