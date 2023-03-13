/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.web.http.server

/**
 * A server-side HTTP exchange handler.
 */
typealias ExchangeHandler = (request: ServerRequest) -> ServerResponse

/**
 * A server-side HTTP router handler.
 */
typealias RouterHandler = (request: ServerRequest) -> ExchangeHandler?
