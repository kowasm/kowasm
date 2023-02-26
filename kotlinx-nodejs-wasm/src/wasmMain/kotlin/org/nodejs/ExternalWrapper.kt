package org.nodejs

external interface JsStringArray {
    fun at(indice: Int): String
    val length: Int
}
