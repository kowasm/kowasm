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

import kotlinx.html.*
import kotlinx.html.stream.createHTML
import org.kowasm.web.http.MediaType
import org.kowasm.web.http.RequestHeaderName
import org.kowasm.web.server.nodejs.startNodejs
import org.kowasm.web.webServer

fun main() {
    webServer {
        router {
            (GET("/") and accept(MediaType.TEXT_HTML)) {
                println(it.headers[RequestHeaderName.ACCEPT])
                ok().body(content)
            }
        }
    }.startNodejs()
}

val content = createHTML().html {
    head {
        meta { charset = "utf-8" }
    }
    body {
        div("user") {
            user(User("Sébastien", 41))
        }
    }
}
