/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.web.http.server

import org.kowasm.web.http.*

/**
 * A server-side response, as returned by [ServerHandler].
 */
interface ServerResponse {

    /**
     * The response status code.
     */
    val status: StatusCode

    /**
     * The response headers.
     */
    val headers: ResponseHeaders

    /**
     * The response body, currently only [String] and [ByteArray] are supported.
     */
    val body: Any?

    /**
     * A builder that adds headers to the response.
     */
    interface HeadersBuilder<B : HeadersBuilder<B>> {

        /**
         * Add the given header.
         *
         * @param name the header name
         * @param value the header value
         */
        fun header(name: ResponseHeaderName, value: String): B

        /**
         * Add the given header.
         *
         * @param name the header name
         * @param value the header value
         */
        fun header(name: String, value: String): B

        /**
         * Build the response with no body.
         */
        fun build(): ServerResponse

    }

    /**
     * A builder that adds a body to the response.
     */
    interface BodyBuilder : HeadersBuilder<BodyBuilder> {

        /**
         * Build the response with the given `body`.
         *
         * @param body the body of the response
         * @return the server response
         */
        fun body(body: Any): ServerResponse

    }

    companion object {

        /**
         * Create a builder with the given HTTP status.
         * @param status the response status
         * @return the created builder
         */
        fun status(status: StatusCode): BodyBuilder {
            return DefaultServerResponseBuilder(status)
        }

        /**
         * Create a builder with the status set to [StatusCode.OK].
         * @return the created builder
         */
        fun ok(): BodyBuilder {
            return status(StatusCode.OK)
        }

        /**
         * Create a builder with a [StatusCode.ACCEPTED] status.
         * @return the created builder
         */
        fun accepted(): BodyBuilder {
            return status(StatusCode.ACCEPTED)
        }

        /**
         * Create a builder with a [StatusCode.NO_CONTENT] status.
         * @return the created builder
         */
        fun noContent(): HeadersBuilder<*> {
            return status(StatusCode.NO_CONTENT)
        }

        /**
         * Create a builder with a [StatusCode.BAD_REQUEST] status.
         * @return the created builder
         */
        fun badRequest(): BodyBuilder {
            return status(StatusCode.BAD_REQUEST)
        }

        /**
         * Create a builder with a [StatusCode.NOT_FOUND] status.
         * @return the created builder
         */
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
