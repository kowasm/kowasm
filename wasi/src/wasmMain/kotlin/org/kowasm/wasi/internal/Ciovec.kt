package org.kowasm.wasi.internal

import kotlin.wasm.unsafe.*

internal data class UnsafeCiovec(
    /** The address of the buffer to be written. */
    var buffer: Pointer,
    /** The length of the buffer to be written. */
    var bufferLength: Size,
)

internal fun storeUnsafeCiovec(ciovec: UnsafeCiovec, pointer: Pointer) {
    (pointer + 0).storeInt(ciovec.buffer.address.toInt())
    (pointer + 4).storeInt(ciovec.bufferLength)
}

internal typealias UnsafeCiovecArray = List<UnsafeCiovec>
