/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.web.server

import org.kowasm.web.webServer
import kotlin.test.Test

class WebServerTests {

    @Test
    fun testMethods() {
        webServer {
            router {
                GET("/now") {
                    ok().body("test")
                }
            }
        }
    }
}
