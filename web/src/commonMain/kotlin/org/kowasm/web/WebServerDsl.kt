package org.kowasm.web

import org.kowasm.core.Dsl
import org.kowasm.web.http.server.RouterDsl
import org.kowasm.web.http.server.RouterHandler

@Dsl
open class WebServerDsl(internal val init: WebServerDsl.() -> Unit) {

    var port: Number = 8080

    var hostname: String = "localhost"

    internal var routerHandler : RouterHandler? = null

    fun router(routes: (RouterDsl.() -> Unit)) {
        routerHandler = RouterDsl(routes).build()
    }

}

fun webServer(dsl: WebServerDsl.() -> Unit =  {}): WebServerDsl {
    return WebServerDsl(dsl).apply { init() }
}
