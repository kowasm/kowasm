/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
