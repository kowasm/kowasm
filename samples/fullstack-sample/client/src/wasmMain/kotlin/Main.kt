/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import kotlinx.browser.document
import org.w3c.dom.HTMLInputElement
import reactivity.computed
import reactivity.ref
import reactivity.watchEffect


fun main() {
    val userDiv = document.body!!.getElementByClassName("user")
    val user by ref(User(
        (userDiv.getElementByClassName("name") as HTMLInputElement).value
        , (userDiv.getElementByClassName("age") as HTMLInputElement).value.toInt()
    ))
    val message by computed { "Hello! My name is <mark>${user.name}</mark>. I'm <mark>${user.age}</mark> years old." }
    watchEffect {
        userDiv.getElementByClassName("message").innerHTML = message
    }
}
