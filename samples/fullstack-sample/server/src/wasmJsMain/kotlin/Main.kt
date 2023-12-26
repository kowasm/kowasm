/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

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
                ok().body(home)
            }
            GET("/client.js") {
                val descriptor = Wasi.openAt("distributions/client.js")
                val fileContent = Wasi.read(descriptor, 10000u).data.decodeToString()
                ok()
                    .contentType(MediaType.APPLICATION_JAVASCRIPT)
                    .body(fileContent)
            }
            GET("/kowasm-client-wasm.wasm") {
                val descriptor = Wasi.openAt("compileSync/wasm/main/productionExecutable/kotlin/kowasm-client-wasm.wasm")
                val fileContent = Wasi.read(descriptor, 100000u).data
                ok()
                    .contentType(MediaType.APPLICATION_WASM)
                    .body(fileContent)
            }
        }
    }.startNodejs()
}

