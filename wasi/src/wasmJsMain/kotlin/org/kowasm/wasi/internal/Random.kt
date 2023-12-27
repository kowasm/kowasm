/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.wasi.internal

import org.kowasm.wasi.WasiException
import kotlin.wasm.WasmImport
import kotlin.wasm.unsafe.withScopedMemoryAllocator

internal fun randomGetInt(): Int {
    withScopedMemoryAllocator { allocator ->
        val pointer = allocator.allocate(Int.SIZE_BYTES)
        val returnCode = rawRandomGet(pointer.address.toInt(), Int.SIZE_BYTES)
        return if (returnCode == 0) {
            pointer.loadInt()
        } else {
            throw WasiException(Errno.values()[returnCode].ordinal)
        }
    }
}

internal fun randomGetLong(): Long {
    withScopedMemoryAllocator { allocator ->
        val pointer = allocator.allocate(Long.SIZE_BYTES)
        val returnCode = rawRandomGet(pointer.address.toInt(), Long.SIZE_BYTES)
        return if (returnCode == 0) {
            pointer.loadLong()
        } else {
            throw WasiException(Errno.values()[returnCode].ordinal)
        }
    }
}

/**
 * Write high-quality random data into a buffer. This function blocks when the implementation is
 * unable to immediately provide sufficient high-quality random data. This function may execute
 * slowly, so when large mounts of random data are required, it's advisable to use this function to
 * seed a pseudo-random number generator, rather than to provide the random data directly.
 */
@WasmImport("wasi_snapshot_preview1", "random_get")
private external fun rawRandomGet(
    arg0: Int,
    arg1: Int,
): Int
