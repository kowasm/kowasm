package org.kowasm.web.http.server

import org.kowasm.web.http.Header
import org.kowasm.web.http.Headers
import org.kowasm.web.http.StatusCode

interface ServerResponse {

    val status: StatusCode

    val headers: Headers

    val body: ByteArray?

    interface HeadersBuilder<B : HeadersBuilder<B>> {

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

class DefaultServerResponseBuilder(val status: StatusCode) : ServerResponse.BodyBuilder {

    private val headers: MutableList<Header> = mutableListOf()

    var body: ByteArray? = null

    override fun body(body: ByteArray): ServerResponse {
        this.body = body
        return this.build()
    }

    override fun body(body: String): ServerResponse {
        this.body = body.encodeToByteArray()
        return this.build()
    }

    override fun header(name: String, vararg value: String): ServerResponse.BodyBuilder {
        headers.add(Header.from(name, value.toList()))
        return this
    }

    override fun build(): ServerResponse {
        return object: ServerResponse {
            override val status: StatusCode
                get() = this@DefaultServerResponseBuilder.status
            override val headers: Headers
                get() = Headers(this@DefaultServerResponseBuilder.headers)
            override val body: ByteArray?
                get() = this@DefaultServerResponseBuilder.body

        }
    }

}
