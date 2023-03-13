# Module wasi

This module exposes a Kotlin/Wasm API inspired from WASI Preview2 in order to expose low level WASI Preview1 capabilities. 

```kotlin
fun main() {
    print()
    clock()
    random()
    filesystem()
    cli()
}

private fun print() {
    Wasi.out.println("== Print ==")

    Wasi.out.println("Hello, world!")
    Wasi.err.println("Error")
}

private fun clock() {
    Wasi.out.println("\n== Clock ==")

    val now = Clock.System.now()
    Wasi.out.println(now)
}

private fun filesystem() {
    Wasi.out.println("\n== Filesystem ==")

    Wasi.createDirectoryAt(StandardDescriptor.FIRST_PREOPEN,"testDir")
    val descriptor = Wasi.openAt(
        StandardDescriptor.FIRST_PREOPEN,
        "testFile",
        OpenFlags(create = true),
        DescriptorFlags(read = true, write = true)
    )
    val content = "Hello, file!"
    Wasi.write(descriptor, content.encodeToByteArray())
    val readResult = Wasi.read(descriptor, content.length.toULong())
    Wasi.out.println(readResult.first.decodeToString())
    Wasi.readDirectory(StandardDescriptor.FIRST_PREOPEN,".").forEach { Wasi.out.println(it) }
}

private fun random() {
    Wasi.out.println("\n== Random ==")

    val pseudoGenerator = SeededWasiRandom()
    Wasi.out.println("Pseudo random number generator")
    Wasi.out.println(pseudoGenerator.nextLong())
    Wasi.out.println(pseudoGenerator.nextLong())

    val secureGenerator = SecureWasiRandom()
    Wasi.out.println("Secure random number generator")
    Wasi.out.println(secureGenerator.nextLong())
    Wasi.out.println(secureGenerator.nextLong())
}

private fun cli() {
    Wasi.out.println("\n== CLI ==")

    Wasi.args.forEach { Wasi.out.println(it) }
    Wasi.envVars.forEach { Wasi.out.println(it) }
}
```

# Package org.kowasm.wasi

Package for WASI public API.

# Package org.kowasm.wasi.internal

Package for WASI internal implementation.