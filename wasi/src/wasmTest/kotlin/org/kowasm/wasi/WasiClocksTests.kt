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