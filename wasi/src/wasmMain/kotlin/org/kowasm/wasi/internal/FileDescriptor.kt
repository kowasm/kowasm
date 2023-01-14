package org.kowasm.wasi.internal

import org.kowasm.wasi.*
import kotlin.wasm.unsafe.*
import kotlin.wasm.WasmImport

/**
 * Standard output file descriptor.
 */
internal val STDOUT: Fd = 1

/**
 * Standard error file descriptor.
 */
internal val STDERR: Fd = 2

internal fun fdWrite(fd: Fd, ivos: List<ByteArray>): Size {
    withScopedMemoryAllocator { allocator ->
        val iovs = ivos.map { UnsafeCiovec(allocator.writeToLinearMemory(it), it.size) }
        val pointer = allocator.allocate(4)
        val returnCode =
            rawFdWrite(
                fd.toInt(),
                allocator.writeToLinearMemory(iovs).address.toInt(),
                iovs.size,
                pointer.address.toInt())
        return if (returnCode == 0) {
            (Pointer(pointer.address.toInt().toUInt())).loadInt()
        } else {
            throw WasiError(Errno.values()[returnCode])
        }
    }
}

/** Write to a file descriptor. Note: This is similar to `writev` in POSIX. */
@WasmImport("wasi_snapshot_preview1", "fd_write")
private external fun rawFdWrite(
    arg0: Int,
    arg1: Int,
    arg2: Int,
    arg3: Int,
): Int