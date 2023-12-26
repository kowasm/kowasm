/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.wasi

import kotlin.test.*

class WasiCliTests {

    @Test
    fun testArgs() {
        assertEquals(listOf("argument1", "argument2"), Wasi.args)
    }

    @Test
    fun testEnvVars() {
        assertEquals(listOf(Pair("PATH", "/usr/local/bin:/usr/bin"), Pair("HOME", "/home/seb")), Wasi.envVars)
    }

}