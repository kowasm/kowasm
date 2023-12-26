/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.wasi

import kotlin.test.Test

class WasiPrintTests {

    @Test
    fun testOutputPrint() {
        Wasi.out.print("Hello, world!")
    }

    @Test
    fun testOutputPrintln() {
        Wasi.out.println("Hello, world!")
    }

    @Test
    fun testErrorPrint() {
        Wasi.err.print("Hello, world!")
    }

    @Test
    fun testErrorPrintln() {
        Wasi.err.println("Hello, world!")
    }

}
