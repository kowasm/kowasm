/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.wasi

/**
 * Thrown when a WASI call fails.
 * TODO Introduce an ErrorCode enum based on the one from wasi-filesystem
 *
 * @param errorCode The error code returned by the WASI call.
 */
class WasiException(val errorCode: Int) : RuntimeException(message = "WASI call failed with $errorCode")