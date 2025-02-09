import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.element.*
import org.kowasm.wasi.SecureWasiRandom
import org.kowasm.wasi.SeededWasiRandom
import org.kowasm.wasi.Wasi

fun BodyContext.home() {
    ul {
        li { a(href = "/clock") { +"Clock" } }
        li { a(href = "/random") { +"Random" } }
        li { a(href = "/filesystem") { +"Filesystem" } }
        li { a(href = "/environment") { +"Environment" } }
    }
}

fun BodyContext.returnHome() {
    p { a(href = "/") { +"Return home" } }
}

fun BodyContext.clock() {
    val now = Wasi.wallClock.now()
    p { +"Current time: $now" }
    returnHome()
}

fun BodyContext.random() {
    val pseudoGenerator = SeededWasiRandom()
    val secureGenerator = SecureWasiRandom()
    p { +"Pseudo random number generator: ${pseudoGenerator.nextLong()}, ${pseudoGenerator.nextLong()}, ${pseudoGenerator.nextLong()}" }
    p { +"Secure random number generator: ${secureGenerator.nextLong()}, ${secureGenerator.nextLong()}, ${secureGenerator.nextLong()}" }
    returnHome()
}

fun BodyContext.filesystem() {
    val descriptor = Wasi.openAt("processedResources/wasmJs/main/test.txt")
    val fileContent = Wasi.read(descriptor, 1024u).data.decodeToString()
    p {
        h2 { +"Content of the file" }
        +fileContent
    }
    returnHome()
}

fun BodyContext.environment() {
    p {
        +"CLI arguments: "
        Wasi.args.forEach { +"$it " }
    }
    p {
        +"Environment variables: "
        Wasi.envVars.forEach { +"${it.first} = ${it.second} " }
    }
    returnHome()
}