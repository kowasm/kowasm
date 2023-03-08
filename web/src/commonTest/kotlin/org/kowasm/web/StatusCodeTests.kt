package org.kowasm.web

import org.kowasm.web.http.StatusCode
import kotlin.test.Test
import kotlin.test.assertEquals

class StatusCodeTests {

    @Test
    fun customStatusCode() {
        assertEquals(StatusCode.Custom(500).code,  StatusCode.INTERNAL_SERVER_ERROR.code)
    }
}