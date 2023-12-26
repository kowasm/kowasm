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

import dev.scottpierce.html.writer.BodyContext
import org.kowasm.web.http.MediaType
import org.kowasm.web.nodejs.startNodejs
import org.kowasm.web.webServer

fun main() {
    webServer {
        router {
            accept(MediaType.TEXT_HTML).nest {
                GET("/") {
                    val content = template("KoWasm WASI webapp demo", BodyContext::home)
                    ok().body(content)
                }
                GET("/clock") {
                    val content = template("WASI clock", BodyContext::clock)
                    ok().body(content)
                }
                GET("/random") {
                    val content = template("WASI random", BodyContext::random)
                    ok().body(content)
                }
                GET("/filesystem") {
                    val content = template("WASI filesystem", BodyContext::filesystem)
                    ok().body(content)
                }
                GET("/environment") {
                    val content = template("WASI environment", BodyContext::environment)
                    ok().body(content)
                }
            }
        }
    }.startNodejs()
}