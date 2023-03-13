package org.kowasm.web.http.server

/**
 * A server-side HTTP exchange handler.
 */
typealias ExchangeHandler = (request: ServerRequest) -> ServerResponse

/**
 * A server-side HTTP router handler.
 */
typealias RouterHandler = (request: ServerRequest) -> ExchangeHandler?
