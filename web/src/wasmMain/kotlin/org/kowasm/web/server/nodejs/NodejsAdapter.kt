package org.kowasm.web.server.nodejs

import org.kowasm.web.HttpHeaders
import org.kowasm.web.Method
import org.kowasm.web.StatusCode
import org.kowasm.web.server.ServerRequest
import org.kowasm.web.server.ServerResponse
import org.kowasm.web.server.WebServerDsl
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
            res.setHeader(header.key, header.value)
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

    override val method: Method
        get() = when (incomingMessage.method) {
            Method.GET.method -> Method.GET
            Method.HEAD.method -> Method.HEAD
            Method.POST.method -> Method.POST
            Method.PUT.method -> Method.PUT
            Method.PATCH.method -> Method.PATCH
            Method.OPTIONS.method -> Method.OPTIONS
            Method.TRACE.method -> Method.TRACE
            Method.DELETE.method -> Method.DELETE
            else -> Method.Other(incomingMessage.method)
        }

    override val path: String
        get() = incomingMessage.url

    override val headers: HttpHeaders
        get() = HttpHeaders().apply {
            for (i in 0 until incomingMessage.rawHeaders.length step 2) {
                val header = incomingMessage.rawHeaders.at(i)
                val value = incomingMessage.rawHeaders.at(i + 1)
                put(header, value)
            }
        }

    override fun <T : Any> body(type: KClass<T>): T {
        TODO()
    }
}
