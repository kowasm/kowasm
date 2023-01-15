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

import org.kowasm.wasi.internal.StandardFileDescriptor
import org.kowasm.wasi.internal.fdWrite

interface WasiPrint {
    /**
     * Prints the given [message] to the standard output.
     */
    fun print(message: String)

    /**
     * Prints the given [message] and the line separator to the standard output.
     */
    fun println(message: String)
}

object DefaultWasiPrint: WasiPrint {

    override fun print(message: String) {
        fdWrite(StandardFileDescriptor.STDOUT.ordinal, listOf(message.encodeToByteArray()))
    }

    override fun println(message: String) {
        print(message + "\n")
    }
}
