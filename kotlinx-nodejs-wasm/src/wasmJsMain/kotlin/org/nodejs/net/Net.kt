@file:JsModule("net")
package org.nodejs.net

open external class Socket

open external class Server {
    open fun listen(port: Int, listeningListener: () -> Unit): Server
    open fun listen(port: Int, hostname: String, listeningListener: () -> Unit): Server
}
