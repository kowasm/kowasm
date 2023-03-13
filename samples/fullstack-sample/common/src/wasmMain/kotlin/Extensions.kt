/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

import org.w3c.dom.Element
import org.w3c.dom.get

fun Element.getElementByClassName(className: String): Element {
    return this.getElementsByClassName(className)[0]!!
}