package org.nodejs.http

import org.nodejs.Dict

external interface IncomingHttpHeaders : Dict<String> {
    var accept: String?
        get() = definedExternally
        set(value) = definedExternally
    var age: String?
        get() = definedExternally
        set(value) = definedExternally
    var allow: String?
        get() = definedExternally
        set(value) = definedExternally
    var authorization: String?
        get() = definedExternally
        set(value) = definedExternally
    var connection: String?
        get() = definedExternally
        set(value) = definedExternally
    var cookie: String?
        get() = definedExternally
        set(value) = definedExternally
    var date: String?
        get() = definedExternally
        set(value) = definedExternally
    var expect: String?
        get() = definedExternally
        set(value) = definedExternally
    var expires: String?
        get() = definedExternally
        set(value) = definedExternally
    var forwarded: String?
        get() = definedExternally
        set(value) = definedExternally
    var from: String?
        get() = definedExternally
        set(value) = definedExternally
    var host: String?
        get() = definedExternally
        set(value) = definedExternally
    var location: String?
        get() = definedExternally
        set(value) = definedExternally
    var origin: String?
        get() = definedExternally
        set(value) = definedExternally
    var pragma: String?
        get() = definedExternally
        set(value) = definedExternally
    var range: String?
        get() = definedExternally
        set(value) = definedExternally
    var referer: String?
        get() = definedExternally
        set(value) = definedExternally
    var tk: String?
        get() = definedExternally
        set(value) = definedExternally
    var trailer: String?
        get() = definedExternally
        set(value) = definedExternally
    var upgrade: String?
        get() = definedExternally
        set(value) = definedExternally
    var vary: String?
        get() = definedExternally
        set(value) = definedExternally
    var via: String?
        get() = definedExternally
        set(value) = definedExternally
    var warning: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface OutgoingHttpHeaders : Dict<String>