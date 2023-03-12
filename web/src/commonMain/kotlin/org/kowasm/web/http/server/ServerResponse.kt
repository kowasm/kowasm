package org.kowasm.web.http.server

import org.kowasm.web.http.*

interface ServerResponse {

    val status: StatusCode

    val headers: ResponseHeaders

    val body: Any?

    interface HeadersBuilder<B : HeadersBuilder<B>> {

        fun header(name: ResponseHeaderName, value: String): B

        fun header(name: String, value: String): B

        fun build(): ServerResponse

    }

    interface BodyBuilder : HeadersBuilder<BodyBuilder> {

        fun body(body: Any): ServerResponse

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

    private val headers: MutableMap<ResponseHeaderName, MutableList<String>> = mutableMapOf()

    var body: Any? = null

    override fun body(body: Any): ServerResponse {
        this.body = body
        return this.build()
    }
    override fun header(name: ResponseHeaderName, value: String): ServerResponse.BodyBuilder {
        if (headers.containsKey(name)) {
            headers[name]!!.add(value)
        }
        else {
            headers[name] = mutableListOf(value)
        }
        return this
    }

    override fun header(name: String, value: String): ServerResponse.BodyBuilder {
        header(name.toResponseHeaderName(), value)
        return this
    }

    override fun build(): ServerResponse {
        return object: ServerResponse {
            override val status: StatusCode
                get() = this@DefaultServerResponseBuilder.status
            override val headers: ResponseHeaders
                get() = ResponseHeaders(this@DefaultServerResponseBuilder.headers)
            override val body: Any?
                get() = this@DefaultServerResponseBuilder.body

        }
    }

}
