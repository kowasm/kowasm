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

import kotlin.test.*

class WasiFileSystemTests {

    @Test
    fun testCreateDirectory() {
        Wasi.createDirectoryAt(StandardDescriptor.FIRST_PREOPEN,"testDir")
    }

    @Test
    fun testCreateWriteReadFile() {
        val descriptor = Wasi.openAt(StandardDescriptor.FIRST_PREOPEN,"testFile",
            OpenFlags(create = true), DescriptorFlags(read = true, write = true))
        Wasi.write(descriptor, "Hello".encodeToByteArray())
        Wasi.write(descriptor, ", world!".encodeToByteArray(), 5u)

        var result = Wasi.read(descriptor, 5u)
        assertEquals("Hello", result.first.decodeToString())
        assertFalse(result.second)

        result = Wasi.read(descriptor, 13u)
        assertEquals("Hello, world!", result.first.decodeToString())
        assertFalse(result.second)

        result = Wasi.read(descriptor, 14u)
        assertEquals("Hello, world!", result.first.decodeToString())
        assertTrue(result.second)

        result = Wasi.read(descriptor, 8u, 5u)
        assertEquals(", world!", result.first.decodeToString())
        assertFalse(result.second)
    }

    @Test
    fun testListDirectoryEntries() {
        Wasi.readDirectory(StandardDescriptor.FIRST_PREOPEN,".").forEach(::println)
    }
}
