/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.web

import org.kowasm.web.http.RequestHeaderName
import kotlin.test.Test
import kotlin.test.assertEquals

class RequestHeaderNameTests {

    @Test
    fun caseInsensitiveEquals() {
        assertEquals<RequestHeaderName>(RequestHeaderName.ACCEPT, RequestHeaderName.Custom("accept"))
    }
}