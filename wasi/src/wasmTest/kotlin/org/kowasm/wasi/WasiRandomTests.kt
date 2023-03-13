/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.wasi

import kotlin.test.Test
import kotlin.test.assertTrue

class WasiRandomTests {

    @Test
    fun testSeededGenerator() {
        val generator = SeededWasiRandom()
        assertTrue(generator.nextFloat() != generator.nextFloat())
        assertTrue(generator.nextDouble() != generator.nextDouble())
        assertTrue(generator.nextInt() != generator.nextInt())
        assertTrue(generator.nextLong() != generator.nextLong())
    }

    @Test
    fun testSecureGenerator() {
        val generator = SecureWasiRandom()
        assertTrue(generator.nextFloat() != generator.nextFloat())
        assertTrue(generator.nextDouble() != generator.nextDouble())
        assertTrue(generator.nextInt() != generator.nextInt())
        assertTrue(generator.nextLong() != generator.nextLong())
        for (i in 0..Int.SIZE_BITS) {
            assertTrue(generator.nextBits(i).countLeadingZeroBits() >= (Int.SIZE_BITS - i))
        }
    }

}
