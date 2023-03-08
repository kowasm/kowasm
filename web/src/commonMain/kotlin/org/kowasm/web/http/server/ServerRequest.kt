package org.kowasm.web.http.server

import org.kowasm.web.http.Headers
import org.kowasm.web.http.Method
import kotlin.reflect.KClass

interface ServerRequest {

    val method: Method

    val path: String

    val headers: Headers

    fun <T: Any> body(type : KClass<T>): T

}