/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.wasi

import org.kowasm.wasi.internal.fdWrite

interface WasiPrint {
    /**
     * Prints the given [message] to the standard output.
     */
    fun print(message: Any)

    /**
     * Prints the given [message] and the line separator to the standard output.
     */
    fun println(message: Any)
}

object OutputWasiPrint: WasiPrint {

    override fun print(message: Any) {
        fdWrite(StandardDescriptor.STDOUT, listOf(message.toString().encodeToByteArray()))
    }

    override fun println(message: Any) {
        print(message.toString() + "\n")
    }
}

object ErrorWasiPrint: WasiPrint {

    override fun print(message: Any) {
        fdWrite(StandardDescriptor.STDERR, listOf(message.toString().encodeToByteArray()))
    }

    override fun println(message: Any) {
        print(message.toString() + "\n")
    }
}
