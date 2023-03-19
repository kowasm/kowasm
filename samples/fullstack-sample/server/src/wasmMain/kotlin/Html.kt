import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.createHtml
import dev.scottpierce.html.writer.element.*
import dev.scottpierce.html.writer.style.Color
import dev.scottpierce.html.writer.style.backgroundColor
import dev.scottpierce.html.writer.style.style
import dev.scottpierce.html.writer.style.styleSheet

internal val home = createHtml {
    head {
        metaCharsetUtf8()
        script(src = "client.js")
        link(rel = "stylesheet", href = "https://unpkg.com/@picocss/pico@1.*/css/pico.min.css")
        styleSheet {
            style(".highlight") {
                backgroundColor(Color("#fff2ca"))
            }
        }
    }
    body {
        div(classes = "user") {
            user(User("Sébastien", 41))
        }
    }
}

internal fun BodyContext.user(user: User) {
    h3(classes = "message") {
        message(user)
    }
    p {
        +"Edit person's name "
        input(classes = "name", value = user.name)
        +" and age "
        input(classes = "age", value = user.age.toString())
    }
}