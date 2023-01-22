package org.kowasm.web.server.nodejs

import org.kowasm.web.HttpHeaders
import org.kowasm.web.HttpMethod
import org.kowasm.web.HttpStatus
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
        val response = handler?.invoke(request) ?: ServerResponse.status(HttpStatus.NOT_FOUND).build()
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

    override val method: HttpMethod
        get() = when (incomingMessage.method) {
            HttpMethod.GET.method -> HttpMethod.GET
            HttpMethod.HEAD.method -> HttpMethod.HEAD
            HttpMethod.POST.method -> HttpMethod.POST
            HttpMethod.PUT.method -> HttpMethod.PUT
            HttpMethod.PATCH.method -> HttpMethod.PATCH
            HttpMethod.OPTIONS.method -> HttpMethod.OPTIONS
            HttpMethod.TRACE.method -> HttpMethod.TRACE
            HttpMethod.DELETE.method -> HttpMethod.DELETE
            else -> HttpMethod.Other(incomingMessage.method)
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
