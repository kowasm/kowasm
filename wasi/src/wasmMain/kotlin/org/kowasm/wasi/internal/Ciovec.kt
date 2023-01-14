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

package org.kowasm.wasi.internal

import kotlin.wasm.unsafe.*

internal data class UnsafeCiovec(
    /** The address of the buffer to be written. */
    var buffer: Pointer,
    /** The length of the buffer to be written. */
    var bufferLength: Size,
)

internal fun storeUnsafeCiovec(ciovec: UnsafeCiovec, pointer: Pointer) {
    (pointer + 0).storeInt(ciovec.buffer.address.toInt())
    (pointer + 4).storeInt(ciovec.bufferLength)
}

internal typealias UnsafeCiovecArray = List<UnsafeCiovec>
