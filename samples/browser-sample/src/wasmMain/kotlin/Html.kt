/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

import dev.scottpierce.html.writer.*
import dev.scottpierce.html.writer.element.*
import kotlinx.browser.window
import org.w3c.dom.Element
import org.w3c.dom.HTMLInputElement
import reactivity.computed
import reactivity.ref
import reactivity.watchEffect

class Html(initialUser: User, private val root: Element) {

    private var user by ref(initialUser)

    init {
        root.innerHTML = component()

        val nameInput = root.getElementByClassName("name-input") as HTMLInputElement
        nameInput.addEventListener("keyup", {
            updateUserIfValid(user.copy(name = nameInput.value))
        })
        val ageInput = root.getElementByClassName("age-input") as HTMLInputElement
        ageInput.addEventListener("keyup", {
            updateUserIfValid(user.copy(age = ageInput.value.toInt()))
        })
        val message by computed { message() }
        watchEffect {
            root.getElementByClassName("message").innerHTML = message
        }
    }

    private fun message() = createInnerHtml {
        span {
            +"Hello! My name is "
            mark { +user.name }
            +". I'm "
            mark { +user.age.toString() }
            +" years old."
        }
    }

    private fun component() = createInnerHtml {
        h3(classes = "message") {
            message()
        }
        p {
            +"Edit person's name "
            input(classes = "name-input", value = user.name)
            +" and age "
            input(classes = "age-input", value = user.age.toString())
        }
    }

    private fun updateUserIfValid(updatedUser: User) {
        val result = updatedUser.validate()
        if (result.errors.isEmpty()) {
            user = updatedUser
        }
        else {
            window.alert(result.errors.joinToString("\n"))
        }
    }
}
