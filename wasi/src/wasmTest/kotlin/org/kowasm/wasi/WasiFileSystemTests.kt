/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
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
