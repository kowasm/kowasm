package org.kowasm.wasi

import org.kowasm.wasi.internal.randomGetInt
import org.kowasm.wasi.internal.randomGetLong
import kotlin.random.Random

/**
 * Provide a pseudo random generator seeded by a [Long] value retrieved via WASI.
 */
fun Random.wasiPseudoGenerator() =
    Random(randomGetLong())

/**
 * Provide a secure random generator.
 */
fun Random.wasiSecureGenerator() = object : Random() {

    override fun nextBits(bitCount: Int) =
        randomGetInt().takeUpperBits(bitCount)

    override fun nextInt() =
        randomGetInt()

    override fun nextLong() =
        randomGetLong()
}

private fun Int.takeUpperBits(bitCount: Int): Int =
    this.ushr(32 - bitCount) and (-bitCount).shr(31)

