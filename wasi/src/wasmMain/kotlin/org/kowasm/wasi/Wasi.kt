/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.wasi

object Wasi : WasiFileSystem by DefaultWasiFilesystem, WasiCli by DefaultWasiCli {

    val out : WasiPrint = OutputWasiPrint

    val err : WasiPrint = ErrorWasiPrint
}
