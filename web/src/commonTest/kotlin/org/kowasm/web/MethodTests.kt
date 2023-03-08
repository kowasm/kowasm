package org.kowasm.web

import org.kowasm.web.http.Method
import kotlin.test.Test
import kotlin.test.assertEquals

class MethodTests {

    @Test
    fun customMethod() {
        assertEquals(Method.Custom("GET").name,  Method.GET.name)
    }
}