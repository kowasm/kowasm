plugins {
    kotlin("multiplatform") version "1.8.20-Beta" apply false
}

allprojects {
    group = "org.kowasm"
    version = "0.1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}
