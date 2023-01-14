package org.kowasm.wasi.internal

import kotlin.wasm.unsafe.*

internal fun MemoryAllocator.writeToLinearMemory(array: ByteArray): Pointer {
    val pointer = allocate(array.size)
    var currentPointer = pointer
    array.forEach {
        currentPointer.storeByte(it)
        currentPointer += 1
    }
    return pointer
}

internal fun MemoryAllocator.writeToLinearMemory(array: UnsafeCiovecArray): Pointer {
    val pointer = allocate(array.size * 8)
    var currentPointer = pointer
    array.forEach {
        storeUnsafeCiovec(it, currentPointer)
        currentPointer += 8
    }
    return pointer
}

internal fun MemoryAllocator.writeToLinearMemory(value: String): Pointer =
    writeToLinearMemory(value.encodeToByteArray())