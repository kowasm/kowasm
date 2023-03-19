# Module web

This module allows to create a web server and defines HTTP routes using a proper DSL.

```kotlin
fun main() {
    val userService = ...
    webServer {
        router {
            GET("/") {
                val content = content(userService.findAll())
                ok().contentType(MediaType.TEXT_HTML).body(content)
            }
            (GET("/api") and accept(MediaType.APPLICATION_JSON)) {
                ok().contentType(MediaType.APPLICATION_JSON).body(userService.findAll())
            }
        }
    }.startNodejs() // could be startServer() when WASI runtimes will support WasmGC
}

fun content(users: List<User>) = createHtml {
    head {
        metaCharsetUtf8()
    }
    body {
        h1 { +"Users" }
        ul {
            users.forEach { user ->
                li { +user.name }
            }
        }
    }
}
```

# Package org.kowasm.web

Package for web related stuff.

# Package org.kowasm.web.http

Package for HTTP related stuff.

# Package org.kowasm.web.http.server

Package for HTTP server related stuff.

# Package org.kowasm.web.nodejs

Package for Nodejs support.