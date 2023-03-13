/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

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

internal fun loadByteArray(addr: Pointer, size: Int): ByteArray =
    ByteArray(size) { i -> (addr + i).loadByte() }

internal fun loadString(addr: Pointer, size: Int): String {
    val bytes = loadByteArray(addr, size)
    val endIndex =
        if (size != 0 && bytes[size - 1] == 0.toByte())
            size - 1  // skip last 0 for 0-terminated strings
        else
            size

    return bytes.decodeToString(endIndex = endIndex)
}