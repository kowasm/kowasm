/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.wasi

import kotlin.test.*

class WasiFileSystemTests {

    @Test
    fun testCreateDirectory() {
        Wasi.createDirectoryAt("testDir")
    }

    @Test
    fun testCreateWriteReadFile() {
        val descriptor = Wasi.openAt("testFile", OpenFlags(create = true), DescriptorFlags(read = true, write = true))
        Wasi.write(descriptor, "Hello".encodeToByteArray())
        Wasi.write(descriptor, ", world!".encodeToByteArray(), 5u)

        var result = Wasi.read(descriptor, 5u)
        assertEquals("Hello", result.data.decodeToString())
        assertFalse(result.eof)

        result = Wasi.read(descriptor, 13u)
        assertEquals("Hello, world!", result.data.decodeToString())
        assertFalse(result.eof)

        result = Wasi.read(descriptor, 14u)
        assertEquals("Hello, world!", result.data.decodeToString())
        assertTrue(result.eof)

        result = Wasi.read(descriptor, 8u, 5u)
        assertEquals(", world!", result.data.decodeToString())
        assertFalse(result.eof)
    }

    @Test
    fun testListDirectoryEntries() {
        Wasi.readDirectory(StandardDescriptor.FIRST_PREOPEN,".").forEach(::println)
    }
}
