package org.kowasm.web.server

import org.kowasm.web.KoWasmDslMarker

@KoWasmDslMarker
open class WebServerDsl(internal val init: WebServerDsl.() -> Unit) {

    var port: Number = 8080

    var hostname: String = "localhost"

    internal var routerHandler : RouterHandler? = null

    fun router(routes: (WebRouterDsl.() -> Unit)) {
        routerHandler = WebRouterDsl(routes).build()
    }

}

fun webServer(dsl: WebServerDsl.() -> Unit =  {}): WebServerDsl {
    return WebServerDsl(dsl).apply { init() }
}
