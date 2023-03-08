package org.kowasm.web.server

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
