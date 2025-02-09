/*
 * Copyright 2023-2025 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

import io.konform.validation.Validation
import io.konform.validation.constraints.maxLength
import io.konform.validation.constraints.maximum
import io.konform.validation.constraints.minLength
import io.konform.validation.constraints.minimum

data class User(val name: String, val age: Int) {

    companion object {
        private val validation = Validation {
            User::name {
                minLength(2)
                maxLength(100)
            }
            User::age {
                minimum(0)
                maximum(150)
            }
        }
    }

    fun validate() = validation.validate(this)

}

