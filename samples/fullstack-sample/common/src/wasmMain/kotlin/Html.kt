/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.element.*

fun BodyContext.message(user: User) {
    span {
        +"Hello! My name is "
        mark { +user.name }
        +". I'm "
        mark { +user.age.toString() }
        +" years old."
    }
}
