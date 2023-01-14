plugins {
    kotlin("multiplatform") version "1.8.255-SNAPSHOT" apply false
}

allprojects {
    group = "org.kowasm"
    version = "0.1.0-SNAPSHOT"

    repositories {
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
        mavenCentral()
    }
}
