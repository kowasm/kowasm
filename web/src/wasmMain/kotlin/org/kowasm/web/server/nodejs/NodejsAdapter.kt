package org.kowasm.web.server.nodejs

import org.kowasm.web.http.server.ServerRequest
import org.kowasm.web.http.server.ServerResponse
import org.kowasm.web.WebServerDsl
import org.kowasm.web.http.*
import org.nodejs.RequestListener
import org.nodejs.http.IncomingMessage
import org.nodejs.http.createServer
import kotlin.reflect.KClass

fun WebServerDsl.listen() {
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
            res.end(response.body!!.decodeToString())
        }
        else {
            // TODO Improve
            res.end("")
        }
    }
    val server = createServer(requestListener)
    server.listen(port, hostname) {
        println("Nodejs server is running on port $port")
    }
}

class NodejsServerRequest(private val incomingMessage: IncomingMessage): ServerRequest {

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
