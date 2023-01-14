package org.kowasm.wasi

import org.kowasm.wasi.internal.*

object Wasi {

    val STDOUT: Fd = 1

    fun println(message: String) {
        fdWrite(STDOUT, listOf(message.toString().encodeToByteArray(), "\n".encodeToByteArray()))
    }
}