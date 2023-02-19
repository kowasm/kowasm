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

import kotlin.test.Test

class WasiPrintTests {

    @Test
    fun testOutputPrint() {
        Wasi.out.print("Hello, world!")
    }

    @Test
    fun testOutputPrintln() {
        Wasi.out.println("Hello, world!")
    }

    @Test
    fun testErrorPrint() {
        Wasi.err.print("Hello, world!")
    }

    @Test
    fun testErrorPrintln() {
        Wasi.err.println("Hello, world!")
    }

}
