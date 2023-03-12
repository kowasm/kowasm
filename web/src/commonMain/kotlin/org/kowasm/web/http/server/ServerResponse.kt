package org.kowasm.web.http.server

import org.kowasm.web.http.*

interface ServerResponse {

    val status: StatusCode

    val headers: ResponseHeaders

    val body: ByteArray?

    interface HeadersBuilder<B : HeadersBuilder<B>> {

        fun header(name: ResponseHeaderName, vararg value: String): B

        fun header(name: String, vararg value: String): B

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

internal class DefaultServerResponseBuilder(val status: StatusCode) : ServerResponse.BodyBuilder {

    private val headers: MutableMap<ResponseHeaderName, List<String>> = mutableMapOf()

    var body: ByteArray? = null

    override fun body(body: ByteArray): ServerResponse {
        this.body = body
        return this.build()
    }

    override fun body(body: String): ServerResponse {
        this.body = body.encodeToByteArray()
        return this.build()
    }

    override fun header(name: ResponseHeaderName, vararg value: String): ServerResponse.BodyBuilder {
        headers[name] = value.toList()
        return this
    }

    override fun header(name: String, vararg value: String): ServerResponse.BodyBuilder {
        headers[name.toResponseHeaderName()] = value.toList()
        return this
    }

    override fun build(): ServerResponse {
        return object: ServerResponse {
            override val status: StatusCode
                get() = this@DefaultServerResponseBuilder.status
            override val headers: ResponseHeaders
                get() = ResponseHeaders(this@DefaultServerResponseBuilder.headers)
            override val body: ByteArray?
                get() = this@DefaultServerResponseBuilder.body

        }
    }

}
