/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.web.http

import org.kowasm.core.util.MultiMap
import org.kowasm.core.util.toMultiMap

/**
 * A request HTTP headers, as defined in the [RFC 7231](https://www.rfc-editor.org/rfc/rfc7231#section-5).
 */
class RequestHeaders(headers: Map<RequestHeaderName, List<String>>) : MultiMap<RequestHeaderName, String> by headers.toMultiMap()

/**
 * A response HTTP headers, as defined in the [RFC 7231](https://www.rfc-editor.org/rfc/rfc7231#section-7).
 */
class ResponseHeaders(headers: Map<ResponseHeaderName, List<String>>) : MultiMap<ResponseHeaderName, String> by headers.toMultiMap()