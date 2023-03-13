/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

import io.konform.validation.Validation
import io.konform.validation.jsonschema.maxLength
import io.konform.validation.jsonschema.maximum
import io.konform.validation.jsonschema.minLength
import io.konform.validation.jsonschema.minimum

data class User(val name: String, val age: Int) {

    companion object {
        private val validation = Validation {
            User::name {
                minLength(2)
                maxLength(100)
            }
            User::age ifPresent {
                minimum(0)
                maximum(150)
            }
        }
    }

    fun validate() = validation.validate(this)

}

