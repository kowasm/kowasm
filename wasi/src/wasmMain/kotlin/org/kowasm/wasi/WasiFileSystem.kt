/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kowasm.wasi

import org.kowasm.wasi.DescriptorType
import org.kowasm.wasi.internal.*
import org.kowasm.wasi.internal.OFlag
import org.kowasm.wasi.internal.Right
import org.kowasm.wasi.internal.StandardFileDescriptor
import org.kowasm.wasi.internal.pathCreateDirectory
import org.kowasm.wasi.internal.pathOpen

/**
 * Filesystem object serial number that is unique within its file system.
 */
typealias INode = ULong

/** The type of a filesystem object referenced by a descriptor.
 *
 * Note: This was called `filetype` in earlier versions of WASI.
 */
enum class DescriptorType {
    /**
     * The type of the descriptor or file is unknown or is different from
     * any of the other types specified.
     */
    UNKNOWN,
    /**
     * The descriptor refers to a block device inode.
     */
    BLOCK_DEVICE,

    /**
     * The descriptor refers to a character device inode.
     */
    CHARACTER_DEVICE,

    /**
     * The descriptor refers to a directory inode.
     */
    DIRECTORY,

    /**
     * The descriptor refers to a named pipe.
     */
    FIFO,

    /**
     * The file refers to a symbolic link inode.
     */
    SYMBOLIC_LINK,

    /**
     * The descriptor refers to a regular file inode.
     */
    REGULAR_FILE,

    /**
     * The descriptor refers to a socket.
     */
    SOCKET
}

/**
 * A directory entry.
 */
data class DirectoryEntry(

    /**
     * The serial number of the object referred to by this directory entry.
     * May be none if the inode value is not known.
     *
     * When this is none, libc implementations might do an extra `stat-at`
     * call to retrieve the inode number to fill their `d_ino` fields, so
     * implementations which can set this to a non-none value should do so.
     */
    val inode: INode?,

    /**
     * The type of the file referred to by this directory entry.
     */
    val type: DescriptorType,

    /**
     * The name of the object.
     */
    val name: String
)

interface WasiFileSystem {

    /**
     * Create a new directory with the given [path] from the root of the first preopen path of the WASI sandbox.
     */
    fun createDirectory(path: String)

    /**
     * Create a new file with the given [path] from the root of the first preopen path of the WASI sandbox.
     */
    fun createFile(path: String)

    /**
     * Return the list of the directory entry (file and directory) names contained in the directory with the given
     * [path] from the root of the first preopen path of the WASI sandbox.
     */
    fun listDirectoryEntries(path: String): List<DirectoryEntry>

}

object DefaultWasiFilesystem: WasiFileSystem {

    override fun createDirectory(path: String) {
        pathCreateDirectory(StandardFileDescriptor.FIRST_PREOPEN.ordinal, path)
    }

    override fun createFile(path: String) {
        pathOpen(StandardFileDescriptor.FIRST_PREOPEN.ordinal, 0, path, OFlag.CREAT, 0, 0, 0)
    }

    override fun listDirectoryEntries(path: String): List<DirectoryEntry> {
        val fd = pathOpen(fd = StandardFileDescriptor.FIRST_PREOPEN.ordinal, dirflags = 0, path = path,
            oflags = OFlag.DIRECTORY,
            fsRightsBase = Right.FD_READDIR,
            fsRightsInheriting = 0,
            fdflags = 0,
        )
        return fdReadDir(fd).map { (entry, name) ->
            DirectoryEntry(entry.inode.toULong(), entry.type.toDescriptorType(), name)
        }
    }

    private fun Filetype.toDescriptorType() = when(this) {
        Filetype.BLOCK_DEVICE -> DescriptorType.BLOCK_DEVICE
        Filetype.CHARACTER_DEVICE -> DescriptorType.CHARACTER_DEVICE
        Filetype.DIRECTORY -> DescriptorType.DIRECTORY
        Filetype.REGULAR_FILE -> DescriptorType.REGULAR_FILE
        Filetype.SYMBOLIC_LINK -> DescriptorType.SYMBOLIC_LINK
        else -> DescriptorType.UNKNOWN
    }
}