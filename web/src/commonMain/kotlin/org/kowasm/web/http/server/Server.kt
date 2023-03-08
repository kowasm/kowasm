package org.kowasm.web.http.server

typealias ServerHandler = (request: ServerRequest) -> ServerResponse

typealias RouterHandler = (request: ServerRequest) -> ServerHandler?
