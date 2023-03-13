/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.wasi

import kotlin.test.*

class WasiClocksTests {

    @Test
    fun testWallClockNow() {
        val dateTime = DefaultWallClock.now()
        assertTrue(dateTime.seconds > (2023 - 1970) * 365 * 24 * 60 * 60)
    }

    @Test
    fun testWallClockResolution() {
        val dateTime = DefaultWallClock.resolution()
        assertEquals(0L, dateTime.seconds)
        assertTrue(dateTime.nanoseconds > 0)
    }

    @Test
    fun testMonotonicClockNow() {
        val instant1 = DefaultMonotonicClock.now()
        val instant2 = DefaultMonotonicClock.now()
        assertTrue(instant2 >= instant1)
    }

    @Test
    fun testMonotonicClockResolution() {
        val instant = DefaultMonotonicClock.resolution()
        assertTrue(instant > 0)
    }

}