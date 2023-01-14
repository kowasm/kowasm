package org.kowasm.wasi

import org.kowasm.wasi.internal.*
import kotlin.time.*

object Wasi {

    val STDOUT: Fd = 1

    fun println(message: String) {
        fdWrite(STDOUT, listOf(message.toString().encodeToByteArray(), "\n".encodeToByteArray()))
    }

    /**
     * Read the current value of the clock.
     *
     * The returned duration represent the time elaspsed since 1970-01-01T00:00:00Z,
     * also known as "POSIX's Seconds Since the Epoch, also known as "Unix Time".
     */
    fun now(): Duration {
        val resolution = clockResGet(ClockId.REALTIME)
        val timestamp = clockTimeGet(ClockId.REALTIME, resolution)
        return timestamp.toDuration(DurationUnit.NANOSECONDS)
    }

}