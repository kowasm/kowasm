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

package org.nodejs.http

import org.nodejs.RequestListener
import kotlin.test.Test
import kotlin.test.assertEquals

class NodeHttpTests {

    @Test
    fun testMethods() {
        assertEquals("GET", METHODS.at(6))
        assertEquals(34, METHODS.length)
    }

    @Test
    fun testStatusCodes() {
        assertEquals("OK", STATUS_CODES[200])
    }

    @Test
    fun testCreateServer() {
        val requestListener: RequestListener = { req, res ->
            println(req.headers.accept)
            res.statusCode = 200
            res.end("Hello, World!")
        }
        createServer(requestListener)
    }

}