package org.kowasm.wasi

import kotlin.random.Random
import kotlin.test.*

class WasiRandomTests {

    @Test
    fun testPseudoGenerator() {
        val generator = Random.wasiPseudoGenerator()
        assertTrue(generator.nextFloat() != generator.nextFloat())
        assertTrue(generator.nextDouble() != generator.nextDouble())
        assertTrue(generator.nextInt() != generator.nextInt())
        assertTrue(generator.nextLong() != generator.nextLong())
    }

    @Test
    fun testSecureGenerator() {
        val generator = Random.wasiSecureGenerator()
        assertTrue(generator.nextFloat() != generator.nextFloat())
        assertTrue(generator.nextDouble() != generator.nextDouble())
        assertTrue(generator.nextInt() != generator.nextInt())
        assertTrue(generator.nextLong() != generator.nextLong())
        for (i in 0..Int.SIZE_BITS) {
            assertTrue(generator.nextBits(i).countLeadingZeroBits() >= (Int.SIZE_BITS - i))
        }
    }

}
