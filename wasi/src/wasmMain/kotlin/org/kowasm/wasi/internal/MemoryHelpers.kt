package org.kowasm.wasi.internal

import kotlin.wasm.unsafe.*

internal fun MemoryAllocator.writeToLinearMemory(array: ByteArray): Pointer {
    val ptr = allocate(array.size)
    var currentPtr = ptr
    for (el in array) {
        currentPtr.storeByte(el)
        currentPtr += 1
    }
    return ptr
}

internal fun MemoryAllocator.writeToLinearMemory(array: UnsafeCiovecArray): Pointer {
    val ptr = allocate(array.size * 8)
    var currentPtr = ptr
    for (el in array) {
        storeUnsafeCiovec(el, currentPtr)
        currentPtr += 8
    }
    return ptr
}

internal fun MemoryAllocator.writeToLinearMemory(string: String): Pointer =
    writeToLinearMemory(string.encodeToByteArray())