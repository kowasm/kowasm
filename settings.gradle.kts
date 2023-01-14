pluginManagement {
    repositories {
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
        mavenCentral()
    }
}

rootProject.name = "kowasm"

include("wasi")
include("samples:wasi-sample")
