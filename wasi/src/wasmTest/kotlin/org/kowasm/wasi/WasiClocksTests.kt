/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.wasi

import kotlin.test.*

class WasiClocksTests {

    @Test
    fun testWallClockNow() {
        val dateTime = Wasi.wallClock.now()
        assertTrue(dateTime.seconds > (2023 - 1970) * 365 * 24 * 60 * 60)
    }

    @Test
    fun testWallClockResolution() {
        val dateTime = Wasi.wallClock.resolution()
        assertEquals(0L, dateTime.seconds)
        assertTrue(dateTime.nanoseconds > 0)
    }

    @Test
    fun testMonotonicClockNow() {
        val instant1 = Wasi.monotonicClock.now()
        val instant2 = Wasi.monotonicClock.now()
        assertTrue(instant2 >= instant1)
    }

    @Test
    fun testMonotonicClockResolution() {
        val instant = Wasi.monotonicClock.resolution()
        assertTrue(instant > 0)
    }

}