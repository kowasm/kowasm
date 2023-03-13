/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.wasi

class WasiError(val error: Any?) : Throwable(message = "WASI call failed with $error")