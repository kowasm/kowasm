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

class UserListener(private val element: Element) {

    private val nameInput = element.getElementByClassName("name") as HTMLInputElement
    private val ageInput = element.getElementByClassName("age") as HTMLInputElement

    private var user by ref(User(nameInput.value, ageInput.value.toInt()))
    private val message by computed { createInnerHtml { message(user) } }

    init {
        watchEffect {
            element.getElementByClassName("message").innerHTML = message
        }
        nameInput.addKeyUpListener {
            updateUserIfValid(user.copy(name = nameInput.value))
        }
        ageInput.addKeyUpListener {
            updateUserIfValid(user.copy(age = ageInput.value.toInt()))
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
