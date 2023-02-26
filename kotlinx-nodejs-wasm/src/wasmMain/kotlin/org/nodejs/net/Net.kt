@file:JsModule("net")
package org.nodejs.net

open external class Socket

open external class Server {
    open fun listen(port: Number = definedExternally, hostname: String = definedExternally, listeningListener: () -> Unit = definedExternally): Server
}
