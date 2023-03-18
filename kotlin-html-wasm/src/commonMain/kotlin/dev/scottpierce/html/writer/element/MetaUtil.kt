package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HeadContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.writer

@HtmlDsl
fun HtmlOutput.metaTitle(title: String) {
    writer {
        HeadContext(this).metaTitle(title)
    }
}

@HtmlDsl
fun HeadContext.metaTitle(title: String) {
    meta(name = "title", content = title)
}

@HtmlDsl
fun HtmlOutput.metaDescription(description: String) {
    writer {
        HeadContext(this).metaDescription(description)
    }
}

@HtmlDsl
fun HeadContext.metaDescription(description: String) {
    meta(name = "description", content = description)
}

@HtmlDsl
fun HtmlOutput.metaCharset(charset: String) {
    writer {
        HeadContext(this).metaCharset(charset)
    }
}

@HtmlDsl
fun HeadContext.metaCharset(charset: String) {
    meta(charset = charset)
}

@HtmlDsl
fun HtmlOutput.metaViewport(viewport: String) {
    writer {
        HeadContext(this).metaViewport(viewport)
    }
}

@HtmlDsl
fun HeadContext.metaViewport(viewport: String) {
    meta(name = "viewport", content = viewport)
}

@HtmlDsl
fun HtmlOutput.metaCharsetUtf8() {
    writer {
        HeadContext(this).metaCharsetUtf8()
    }
}

@HtmlDsl
fun HeadContext.metaCharsetUtf8() {
    metaCharset("utf-8")
}
