import org.kowasm.wasi.Wasi

fun main() {
    Wasi.println("Hello, world!")
    Wasi.println(Wasi.now().toString())
    Wasi.createDirectory("testDir")
}
