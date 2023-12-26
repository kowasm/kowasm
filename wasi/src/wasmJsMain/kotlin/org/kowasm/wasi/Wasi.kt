/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.wasi

import kotlin.random.Random

/**
 * Provides access to WASI APIs.
 */
object Wasi : WasiFileSystem by DefaultWasiFilesystem, WasiCli by DefaultWasiCli {

    /** The standard output. */
    val out : WasiPrint = OutputWasiPrint

    /** The standard error. */
    val err : WasiPrint = ErrorWasiPrint

    /** Default monotonic clock, suitable for general-purpose application needs. */
    val monotonicClock: MonotonicClock = DefaultMonotonicClock

    /**
     * Default wall clock, suitable for general-purpose application needs.
     */
    val wallClock: WallClock = DefaultWallClock

    /**
     * Provide a pseudo random generator seeded by a `Long` value generated via WASI.
     */
    fun seededRandom(): Random = SeededWasiRandom()

    /**
     * Provide a secure random generator implemented via WASI.
     */
    fun secureRandom(): Random = SecureWasiRandom()
}
