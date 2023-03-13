/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

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