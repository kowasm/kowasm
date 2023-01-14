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

import org.kowasm.wasi.internal.*
import kotlin.time.*

object Wasi {

    /**
     * Prints the given [message] to the standard output.
     */
    fun print(message: String) {
        fdWrite(StandardFileDescriptor.STDOUT.ordinal, listOf(message.toString().encodeToByteArray()))
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
        pathCreateDirectory(StandardFileDescriptor.FIRST_PREOPEN.ordinal, path)
    }

}