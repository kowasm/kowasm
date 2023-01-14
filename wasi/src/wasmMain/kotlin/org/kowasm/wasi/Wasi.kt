package org.kowasm.wasi

import org.kowasm.wasi.internal.*
import kotlin.time.*

object Wasi {

    /**
     * Prints the given [message] to the standard output.
     */
    fun print(message: String) {
        fdWrite(STDOUT, listOf(message.toString().encodeToByteArray()))
    }

    /**
     * Prints the given [message] and the line separator to the standard output.
     */
    fun println(message: String) {
        print(message + "\n")
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

    /**
     * Create a new directory with the given [path].
     */
    fun createDirectory(path: String) {
        pathCreateDirectory(PREOPEN, path)
    }

}