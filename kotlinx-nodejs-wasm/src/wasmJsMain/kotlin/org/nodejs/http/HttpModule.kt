/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:JsModule("http")
package org.nodejs.http

import org.nodejs.JsStringArray
import org.nodejs.Readable
import org.nodejs.RequestListener
import org.nodejs.Writable
import org.nodejs.net.Socket
import org.nodejs.net.Server as NetServer

external var METHODS: JsStringArray

@Suppress("ClassName")
external object STATUS_CODES {

    operator fun get(errorCode: Int): String?

    operator fun set(errorCode: Int, value: String?)

    operator fun get(errorCode: String): String?

    operator fun set(errorCode: String, value: String?)
}

open external class Server : NetServer {
    constructor(requestListener: RequestListener)
}

open external class IncomingMessage(socket: Socket) : Readable {
    open var aborted: Boolean
    open var httpVersion: String
    open var httpVersionMajor: Int
    open var httpVersionMinor: Int
    open var complete: Boolean
    open var connection: Socket
    open var socket: Socket
    open var rawHeaders: JsStringArray
    open var rawTrailers: JsStringArray
    open fun setTimeout(msecs: Int): IncomingMessage
    open fun setTimeout(msecs: Int, callback: () -> Unit): IncomingMessage
    open var method: String
    open var url: String
    open var statusCode: Int
    open var statusMessage: String
}

open external class OutgoingMessage : Writable {
    open var upgrading: Boolean
    open var chunkedEncoding: Boolean
    open var shouldKeepAlive: Boolean
    open var useChunkedEncodingByDefault: Boolean
    open var sendDate: Boolean
    open var finished: Boolean
    open var headersSent: Boolean
    open var connection: Socket
    open var socket: Socket
    open fun setTimeout(msecs: Int): OutgoingMessage
    open fun setTimeout(msecs: Int, callback: () -> Unit): OutgoingMessage
    open fun setHeader(name: String, value: Int)
    open fun setHeader(name: String, value: String)
    open fun setHeader(name: String, value: JsStringArray)
    open fun getHeaderNames(): JsStringArray
    open fun hasHeader(name: String): Boolean
    open fun removeHeader(name: String)
    open fun flushHeaders()
}

open external class ServerResponse(req: IncomingMessage) : OutgoingMessage {
    open var statusCode: Int
    open var statusMessage: String
    open fun assignSocket(socket: Socket)
    open fun detachSocket(socket: Socket)
    open fun writeContinue(callback: () -> Unit)
    open fun writeHead(statusCode: Int): ServerResponse
    open fun writeHead(statusCode: Int, reasonPhrase: String): ServerResponse
    open fun writeProcessing()
}


external fun createServer(requestListener: RequestListener): Server