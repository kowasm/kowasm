package org.kowasm.web

@DslMarker
internal annotation class KoWasmDslMarker

@KoWasmDslMarker
abstract class AbstractDsl {

    open fun initialize() {
    }

}
