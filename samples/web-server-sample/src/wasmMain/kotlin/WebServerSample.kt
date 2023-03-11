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

import kotlinx.datetime.Clock
import kotlinx.html.body
import kotlinx.html.h1
import kotlinx.html.html
import kotlinx.html.p
import kotlinx.html.stream.createHTML
import org.kowasm.wasi.*
import org.kowasm.web.http.MediaType
import org.kowasm.web.http.RequestHeaderName
import org.kowasm.web.server.nodejs.listen
import org.kowasm.web.webServer

fun main() {
    webServer {
        router {
            (GET("/") and accept(MediaType.TEXT_HTML)) {
                println(it.headers[RequestHeaderName.ACCEPT])
                ok().body(content)
            }
        }
    }.listen()
}

val content = createHTML().html {
    val now = Clock.System.now()
    val pseudoGenerator = SeededWasiRandom()
    val secureGenerator = SecureWasiRandom()
    val descriptor = Wasi.openAt(
        StandardDescriptor.FIRST_PREOPEN,
        "processedResources/wasm/main/test.txt",
        OpenFlags(), DescriptorFlags(read = true)
    )

    val fileContent = Wasi.read(descriptor, 1024u).first.decodeToString()
    body {
        h1 { +"Kotlin/Wasm WASI web server demo" }
        p { +"Current time: $now" }
        p { +"Pseudo random number generator: ${pseudoGenerator.nextLong()}, ${pseudoGenerator.nextLong()}, ${pseudoGenerator.nextLong()}" }
        p { +"Secure random number generator: ${secureGenerator.nextLong()}, ${secureGenerator.nextLong()}, ${secureGenerator.nextLong()}" }
        p {
            +"Arguments: "
            Wasi.args.forEach { +"$it " }
        }
        p {
            +"Environment variables: "
            Wasi.envVars.forEach { +"${it.first} = ${it.second} " }
        }
        p {
            +"Content of a file: "
            +fileContent
        }
    }
}
