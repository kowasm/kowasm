package org.kowasm.web.server

import org.kowasm.web.AbstractDsl

open class WebServerDsl(private val init: WebServerDsl.() -> Unit): AbstractDsl() {

    var port: Number = 8080

    var hostname: String = "localhost"

    internal var routerHandler : RouterHandler? = null

    override fun initialize() {
        init()
    }

    fun router(routes: (WebRouterDsl.() -> Unit)) {
        routerHandler = WebRouterDsl(routes).build()
    }

}

fun webServer(dsl: WebServerDsl.() -> Unit =  {}): WebServerDsl {
    return WebServerDsl(dsl).apply { initialize() }
}
