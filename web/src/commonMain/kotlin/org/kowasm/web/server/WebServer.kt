package org.kowasm.web.server

import org.kowasm.web.HttpHeaders
import org.kowasm.web.Method
import org.kowasm.web.StatusCode
import kotlin.reflect.KClass

typealias ServerHandler = (request: ServerRequest) -> ServerResponse

typealias RouterHandler = (request: ServerRequest) -> ServerHandler?

interface ServerRequest {

    val method: Method

    val path: String

    val headers: HttpHeaders

    fun <T: Any> body(type : KClass<T>): T

}

interface ServerResponse {

    val status: StatusCode

    val headers: HttpHeaders

    val body: ByteArray?

    interface HeadersBuilder<B : HeadersBuilder<B>> {

        fun header(headerName: String, headerValue: String): B

        fun build(): ServerResponse

    }

    interface BodyBuilder : HeadersBuilder<BodyBuilder> {

        fun body(body: ByteArray): ServerResponse

        fun body(body: String): ServerResponse
    }

    companion object {

        fun status(status: StatusCode): BodyBuilder {
            return DefaultServerResponseBuilder(status)
        }

        fun ok(): BodyBuilder {
            return status(StatusCode.OK)
        }

        fun accepted(): BodyBuilder {
            return status(StatusCode.ACCEPTED)
        }

        fun noContent(): HeadersBuilder<*> {
            return status(StatusCode.NO_CONTENT)
        }

        fun badRequest(): BodyBuilder {
            return status(StatusCode.BAD_REQUEST)
        }

        fun notFound(): HeadersBuilder<*> {
            return status(StatusCode.NOT_FOUND)
        }
    }
}

class DefaultServerResponseBuilder(val status: StatusCode) : ServerResponse.BodyBuilder {

    private val headers: HttpHeaders = HttpHeaders()

    var body: ByteArray? = null

    override fun body(body: ByteArray): ServerResponse {
        this.body = body
        return this.build()
    }

    override fun body(body: String): ServerResponse {
        this.body = body.encodeToByteArray()
        return this.build()
    }

    override fun header(headerName: String, headerValue: String): ServerResponse.BodyBuilder {
        headers[headerName] = headerValue
        return this
    }

    override fun build(): ServerResponse {
        return object: ServerResponse {
            override val status: StatusCode
                get() = this@DefaultServerResponseBuilder.status
            override val headers: HttpHeaders
                get() = this@DefaultServerResponseBuilder.headers
            override val body: ByteArray?
                get() = this@DefaultServerResponseBuilder.body

        }
    }

}
