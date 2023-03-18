import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.createHtml
import dev.scottpierce.html.writer.element.*

internal val home = createHtml {
    head {
        metaCharsetUtf8()
        script(src = "client.js")
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