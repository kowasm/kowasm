package org.kowasm.wasi.internal

import org.kowasm.wasi.*
import kotlin.wasm.unsafe.*
import kotlin.wasm.WasmImport

/**
 * Standard file descriptors.
 */
internal enum class StandardFileDescriptor {
    /** Standard input file descriptor. */
    STDIN,
    /** Standard output file descriptor. */
    STDOUT,
    /** Standard error file descriptor. */
    STDERR,
    /** First preopen file descriptor. */
    FIRST_PREOPEN,
}

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

internal fun pathCreateDirectory(fd: Fd, path: String) {
    withScopedMemoryAllocator { allocator ->
        val bytes = path.encodeToByteArray()
        val returnCode = rawPathCreateDirectory(fd.toInt(), allocator.writeToLinearMemory(bytes).address.toInt(), bytes.size)
        return if (returnCode == 0) {
            Unit
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

/** Create a directory. Note: This is similar to `mkdirat` in POSIX. */
@WasmImport("wasi_snapshot_preview1", "path_create_directory")
private external fun rawPathCreateDirectory(
    arg0: Int,
    arg1: Int,
    arg2: Int,
): Int