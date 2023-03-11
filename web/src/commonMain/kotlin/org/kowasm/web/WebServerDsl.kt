package org.kowasm.web

import org.kowasm.core.Dsl
import org.kowasm.web.http.server.RouterDsl
import org.kowasm.web.http.server.RouterHandler

/**
 * Dsl for configuring a web server.
 *
 * @param host the host to bind to
 * @param port the port to bind to
 */
@Dsl
open class WebServerDsl(var host: String, var port: Number, internal val init: WebServerDsl.() -> Unit) {

    internal var routerHandler : RouterHandler? = null

    /**
     * Configures a router.
     */
    fun router(routes: (RouterDsl.() -> Unit)) {
        routerHandler = RouterDsl(routes).build()
    }

}

/**
 * Configures a web server.
 *
 * @param host the host to bind to
 * @param port the port to bind to
 */
fun webServer(host: String = "localhost", port: Number = 8080, dsl: WebServerDsl.() -> Unit): WebServerDsl {
    return WebServerDsl(host, port, dsl).apply { init() }
}
