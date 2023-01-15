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

import org.kowasm.wasi.internal.*
import org.kowasm.wasi.internal.OFlag
import org.kowasm.wasi.internal.Right
import org.kowasm.wasi.internal.StandardFileDescriptor
import org.kowasm.wasi.internal.pathCreateDirectory
import org.kowasm.wasi.internal.pathOpen

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
    fun listDirectoryEntries(path: String): List<String>

}

object DefaultWasiFilesystem: WasiFileSystem {

    override fun createDirectory(path: String) {
        pathCreateDirectory(StandardFileDescriptor.FIRST_PREOPEN.ordinal, path)
    }

    override fun createFile(path: String) {
        pathOpen(StandardFileDescriptor.FIRST_PREOPEN.ordinal, 0, path, OFlag.CREAT, 0, 0, 0)
    }

    override fun listDirectoryEntries(path: String): List<String> {
        val fd = pathOpen(fd = StandardFileDescriptor.FIRST_PREOPEN.ordinal, dirflags = 0, path = path,
            oflags = OFlag.DIRECTORY,
            fsRightsBase = Right.FD_READDIR,
            fsRightsInheriting = 0,
            fdflags = 0,
        )
        return fdReadDir(fd)
    }
}