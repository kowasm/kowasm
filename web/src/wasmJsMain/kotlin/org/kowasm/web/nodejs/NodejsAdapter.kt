/*
 * Copyright 2023-2025 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.web.nodejs

import org.khronos.webgl.toUint8Array
import org.kowasm.web.WebServerDsl
import org.kowasm.web.http.*
import org.kowasm.web.http.server.ServerRequest
import org.kowasm.web.http.server.ServerResponse
import org.nodejs.RequestListener
import org.nodejs.http.IncomingMessage
import org.nodejs.http.createServer
import kotlin.collections.MutableList
import kotlin.collections.iterator
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import kotlin.collections.set
import kotlin.collections.toMap
import kotlin.collections.toUByteArray
import kotlin.reflect.KClass

/**
 * Starts a Nodejs server listening on the specified host and port.
 */
@ExperimentalUnsignedTypes
fun WebServerDsl.startNodejs() {
    val requestListener: RequestListener = { req, res ->
        val request = NodejsServerRequest(req)
        val handler = routerHandler!!.invoke(request)
        val response = handler?.invoke(request) ?: ServerResponse.status(StatusCode.NOT_FOUND).build()
        res.statusCode = response.status.code
        for (header in response.headers) {
            for (value in header.value) {
                res.setHeader(header.key.name, value)
            }
        }
        if (response.body != null) {
            if (response.body is String) {
                res.end(response.body as String)
            }
            else if (response.body is ByteArray) {
                res.end((response.body as ByteArray).asUByteArray().toUint8Array())
            }
            else {
                throw UnsupportedOperationException("Only String body is supported")
            }
        }
        else {
            // TODO Improve
            res.end("")
        }
    }
    val server = createServer(requestListener)
    server.listen(port, host) {
        println("Nodejs server is running on port $port")
    }
}

private class NodejsServerRequest(private val incomingMessage: IncomingMessage): ServerRequest {

    override val method: Method by lazy {
        incomingMessage.method.toMethod()
    }

    override val path: String
        get() = incomingMessage.url

    override val headers: RequestHeaders by lazy {
        val headersMap = mutableMapOf<RequestHeaderName, MutableList<String>>()
        val headerNames = incomingMessage.rawHeaders
        for (i in 0 until headerNames.length step 2) {
            val name = headerNames.at(i).toRequestHeaderName()
            val value = headerNames.at(i + 1)
            if (headersMap.containsKey(name)){
                headersMap[name]!!.add(value)
            }
            else {
                headersMap[name] = mutableListOf(value)
            }
        }
        RequestHeaders(headersMap.toMap())
    }

    override fun <T : Any> body(type: KClass<T>): T {
        TODO()
    }
}
