package org.kowasm.wasi

import kotlin.test.Test

class WasiTests {

    @Test
    fun testPrint() {
        Wasi.print("Hello, world!")
    }

    @Test
    fun testPrintln() {
        Wasi.println("Hello, world!")
    }

    @Test
    fun testNow() {
        Wasi.println(Wasi.now().toString())
    }
}
