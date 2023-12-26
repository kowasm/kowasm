/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.wasi

import org.kowasm.wasi.internal.randomGetInt
import org.kowasm.wasi.internal.randomGetLong
import kotlin.random.Random

/**
 * Provide a pseudo random generator seeded by a `Long` value generated via WASI.
 */
fun SeededWasiRandom() = Random(randomGetLong())

/**
 * Provide a secure random generator implemented via WASI.
 */
class SecureWasiRandom : Random() {

    override fun nextBits(bitCount: Int) =
        randomGetInt().takeUpperBits(bitCount)

    override fun nextInt() =
        randomGetInt()

    override fun nextLong() =
        randomGetLong()

    private fun Int.takeUpperBits(bitCount: Int): Int =
        this.ushr(32 - bitCount) and (-bitCount).shr(31)

}
