/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

import kotlinx.html.*

fun DIV.user(user: User) {
        h3("message") {
            +"Hello! My name is <mark>${user.name}</mark>. I'm <mark>${user.age}</mark> years old."
        }
        p {
            +"Edit person's name "
            input(classes = "name") {
                value = user.name
            }
            +" and age "
            input(classes = "age") {
                value = user.age.toString()
            }
        }
}
