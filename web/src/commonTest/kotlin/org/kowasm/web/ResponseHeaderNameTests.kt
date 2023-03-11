package org.kowasm.web

import org.kowasm.web.http.ResponseHeaderName
import kotlin.test.Test
import kotlin.test.assertEquals

class ResponseHeaderNameTests {

    @Test
    fun caseInsensitiveEquals() {
        assertEquals<ResponseHeaderName>(ResponseHeaderName.AGE, ResponseHeaderName.Custom("age"))
    }
}