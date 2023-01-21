plugins {
    kotlin("multiplatform") version "1.8.20-dev-6044" apply false
}

allprojects {
    group = "org.kowasm"
    version = "0.1.0-SNAPSHOT"

    repositories {
        maven(url = "https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
        mavenCentral()
    }
}
