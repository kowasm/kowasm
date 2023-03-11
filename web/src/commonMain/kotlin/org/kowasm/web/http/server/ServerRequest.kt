package org.kowasm.web.http.server

import org.kowasm.web.http.Method
import org.kowasm.web.http.RequestHeaders
import kotlin.reflect.KClass

interface ServerRequest {

    val method: Method

    val path: String

    val headers: RequestHeaders

    fun <T: Any> body(type : KClass<T>): T

}