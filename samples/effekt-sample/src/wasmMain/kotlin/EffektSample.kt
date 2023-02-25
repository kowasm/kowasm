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
import kotlinx.html.InputType
import kotlinx.html.dom.append
import kotlinx.html.h3
import kotlinx.html.input
import kotlinx.html.js.onKeyUpFunction
import kotlinx.html.p
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.Node
import reactivity.computed
import reactivity.ref
import reactivity.watchEffect

var surname by ref("Sébastien")
var age by ref(41)
val message by computed { "Hello! My name is <mark>$surname</mark>. I'm <mark>$age</mark> years old." }

fun main() {
    document.body?.init()
    watchEffect {
        document.getElementByClassName("message").innerHTML = message
    }
}

fun Node.init() {
    append {
        h3("message")
        p {
            +"Edit person's name "
            input(type = InputType.text, classes = "person-name-input") {
                value = surname
                onKeyUpFunction = {
                    surname = (it.target as HTMLInputElement).value
                }
            }
            +" and age "
            input(type = InputType.text, classes = "person-age-input") {
                value = age.toString()
                onKeyUpFunction = {
                    age = (it.target as HTMLInputElement).value.toInt()
                }
            }
        }
    }
}