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