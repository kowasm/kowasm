@file:JsModule("net")
package org.nodejs.net

open external class Socket

open external class Server {
    open fun listen(port: Number, listeningListener: () -> Unit): Server
    open fun listen(port: Number, hostname: String, listeningListener: () -> Unit): Server
}
