/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

import kotlinx.browser.document


fun main() {
    val userDiv = document.body!!.getElementByClassName("user")
    Html(userDiv)
}