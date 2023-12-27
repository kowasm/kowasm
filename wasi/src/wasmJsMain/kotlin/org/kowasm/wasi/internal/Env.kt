/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.wasi.internal

import org.kowasm.wasi.WasiException
import kotlin.wasm.WasmImport
import kotlin.wasm.unsafe.Pointer
import kotlin.wasm.unsafe.withScopedMemoryAllocator

/**
 * Read environment variable data.
 */
internal fun environGet(): Map<String, String> {
    val (numArgs, bufSize) = environSizesGet()
    val tmpByteArray = ByteArray(bufSize)
    withScopedMemoryAllocator { allocator ->
        val environ = allocator.allocate(numArgs * 4)
        val environBuffer = allocator.allocate(bufSize)
        val ret = wasmEnvironGet(environ.address.toInt(), environBuffer.address.toInt())
        if (ret != 0) {
            throw WasiException(Errno.values()[ret].ordinal)
        }
        val result = mutableMapOf<String, String>()
        repeat(numArgs) { idx ->
            val environPtr = environ + idx * 4
            var ptr = Pointer(environPtr.loadInt().toUInt())
            val endIdx = readZeroTerminatedByteArray(ptr, tmpByteArray)
            val str = tmpByteArray.decodeToString(endIndex = endIdx)
            val (key, value) = str.split("=", limit = 2)
            result[key] = value
        }
        return result
    }
}

private fun environSizesGet(): Pair<Size, Size> {
    withScopedMemoryAllocator { allocator ->
        val rp0 = allocator.allocate(4)
        val rp1 = allocator.allocate(4)
        val ret = wasmEnvironSizesGet(rp0.address.toInt(), rp1.address.toInt())
        return if (ret == 0) {
            Pair(
                (Pointer(rp0.address.toInt().toUInt())).loadInt(),
                (Pointer(rp1.address.toInt().toUInt())).loadInt())
        } else {
            throw WasiException(Errno.values()[ret].ordinal)
        }
    }
}

@WasmImport("wasi_snapshot_preview1", "environ_get")
private external fun wasmEnvironGet(
    arg0: Int,
    arg1: Int,
): Int

@WasmImport("wasi_snapshot_preview1", "environ_sizes_get")
private external fun wasmEnvironSizesGet(
    arg0: Int,
    arg1: Int,
): Int