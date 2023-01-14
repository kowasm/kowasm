package org.kowasm.wasi

class WasiError(val error: Any?) : Throwable(message = "WASI call failed with $error")