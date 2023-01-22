package org.kowasm.web.server

import kotlinx.datetime.Clock
import kotlin.test.Test

class WebServerTests {

    @Test
    fun testMethods() {
        webServer {
            router {
                GET("/now") {
                    ok().body(Clock.System.now().toString())
                }
            }
        }
    }
}
