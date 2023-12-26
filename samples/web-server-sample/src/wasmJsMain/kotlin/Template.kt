import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.createHtml
import dev.scottpierce.html.writer.element.*
import dev.scottpierce.html.writer.style.*

fun template(title: String, content: BodyContext.() -> Unit) = createHtml {
    head {
        metaCharsetUtf8()
        styleSheet {
            style("body") {
                fontFamily("Roboto,Oxygen-Sans,Ubuntu,Cantarell,helvetica,sans-serif")
                fontSize(1.5.rem)
                lineHeight(1.5.em)
            }
            style(".container") {
                margin(1.rem, Dimension.AUTO)
                maxWidth(90.rem)
            }
        }
    }
    body {
        div(classes = "container") {
            h1 { +title }
            content()
        }
    }
}