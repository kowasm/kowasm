/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

import dev.scottpierce.html.writer.createInnerHtml
import kotlinx.browser.window
import org.w3c.dom.Element
import org.w3c.dom.HTMLInputElement
import reactivity.computed
import reactivity.ref
import reactivity.watchEffect

class Html(private val root: Element) {

    private val nameInput = root.getElementByClassName("name") as HTMLInputElement
    private val ageInput = root.getElementByClassName("age") as HTMLInputElement

    private var user by ref(User(nameInput.value, ageInput.value.toInt()))

    init {
        val message by computed { createInnerHtml { message(user) } }
        watchEffect {
            root.getElementByClassName("message").innerHTML = message
        }

        nameInput.addEventListener("keyup", {
            updateUserIfValid(user.copy(name = nameInput.value))
        })

        ageInput.addEventListener("keyup", {
            updateUserIfValid(user.copy(age = ageInput.value.toInt()))
        })
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
