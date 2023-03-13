/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

import kotlinx.html.*
import kotlinx.html.stream.createHTML
import org.kowasm.wasi.DescriptorFlags
import org.kowasm.wasi.OpenFlags
import org.kowasm.wasi.StandardDescriptor
import org.kowasm.wasi.Wasi
import org.kowasm.web.http.MediaType
import org.kowasm.web.http.RequestHeaderName
import org.kowasm.web.nodejs.startNodejs
import org.kowasm.web.webServer

fun main() {
    webServer {
        router {
            (GET("/") and accept(MediaType.TEXT_HTML)) {
                println(it.headers[RequestHeaderName.ACCEPT])
                ok().body(content)
            }
            GET("/client.js") {
                val descriptor = Wasi.openAt(
                    StandardDescriptor.FIRST_PREOPEN,
                    "distributions/client.js",
                    OpenFlags(), DescriptorFlags(read = true)
                )
                val fileContent = Wasi.read(descriptor, 10000u).first.decodeToString()
                ok()
                    .contentType(MediaType.APPLICATION_JAVASCRIPT)
                    .body(fileContent)
            }
            GET("/kowasm-client-wasm.wasm") {
                val descriptor = Wasi.openAt(
                    StandardDescriptor.FIRST_PREOPEN,
                    "compileSync/wasm/main/productionExecutable/kotlin/kowasm-client-wasm.wasm",
                    OpenFlags(), DescriptorFlags(read = true)
                )
                val fileContent = Wasi.read(descriptor, 100000u).first
                ok()
                    .contentType(MediaType.APPLICATION_WASM)
                    .body(fileContent)
            }
        }
    }.startNodejs()
}

val content = createHTML().html {
    head {
        meta { charset = "utf-8" }
        script {
            type = "application/ecmascript"
            src = "client.js"
        }
    }
    body {
        div("user") {
            user(User("Sébastien", 41))
        }
    }
}
