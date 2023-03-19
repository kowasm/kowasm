/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.wasi

import org.kowasm.wasi.internal.argsGet
import org.kowasm.wasi.internal.environGet

/**
 * Provides access to the command line arguments and environment variables.
 */
interface WasiCli {

    /**
     * The command line arguments.
     */
    val args: List<String>

    /**
     * The environment variables.
     */
    val envVars: List<Pair<String, String>>

}

/**
 * Default implementation of [WasiCli].
 */
object DefaultWasiCli : WasiCli {

    override val args: List<String>
        get() = argsGet()

    override val envVars: List<Pair<String, String>>
        get() = environGet().map { Pair(it.key, it.value) }
}