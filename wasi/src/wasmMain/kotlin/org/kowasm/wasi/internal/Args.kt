/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.wasi.internal

import org.kowasm.wasi.WasiError
import kotlin.wasm.WasmImport
import kotlin.wasm.unsafe.Pointer
import kotlin.wasm.unsafe.withScopedMemoryAllocator

/**
 * Read command-line argument data.
 */
internal fun argsGet(): List<String> {
    val (numArgs, bufSize) = argsSizesGet()
    val byteArrayBuf = ByteArray(bufSize)
    withScopedMemoryAllocator { allocator ->
        val argv = allocator.allocate(numArgs * 4)
        val argvBuffer = allocator.allocate(bufSize)
        val ret = wasmArgsGet(argv.address.toInt(), argvBuffer.address.toInt())
        if (ret != 0) {
            throw WasiError(Errno.values()[ret])
        }
        val result = mutableListOf<String>()
        repeat(numArgs) { idx ->
            val argvPtr = argv + idx * 4
            var ptr = Pointer(argvPtr.loadInt().toUInt())
            val endIndex = readZeroTerminatedByteArray(ptr, byteArrayBuf)
            val str = byteArrayBuf.decodeToString(endIndex = endIndex)
            result += str
        }
        return result
    }
}

internal fun readZeroTerminatedByteArray(ptr: Pointer, byteArray: ByteArray): Int {
    for (i in byteArray.indices) {
        val b = (ptr + i).loadByte()
        if (b.toInt() == 0)
            return i
        byteArray[i] = b
    }
    error("Zero-terminated array is out of bounds")
}

/** Return command-line argument data sizes. */
private fun argsSizesGet(): Pair<Size, Size> {
    withScopedMemoryAllocator { allocator ->
        val rp0 = allocator.allocate(4)
        val rp1 = allocator.allocate(4)
        val ret = wasmArgsSizesGet(rp0.address.toInt(), rp1.address.toInt())
        return if (ret == 0) {
            Pair(
                (Pointer(rp0.address.toInt().toUInt())).loadInt(),
                (Pointer(rp1.address.toInt().toUInt())).loadInt())
        } else {
            throw WasiError(Errno.values()[ret])
        }
    }
}

@WasmImport("wasi_snapshot_preview1", "args_get")
private external fun wasmArgsGet(
    arg0: Int,
    arg1: Int,
): Int

@WasmImport("wasi_snapshot_preview1", "args_sizes_get")
private external fun wasmArgsSizesGet(
    arg0: Int,
    arg1: Int,
): Int