/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

@file:Suppress("MayBeConstant", "RedundantNullableReturnType", "UNUSED_PARAMETER")
package org.kowasm.componentmodel

// Kotlin equivalent of WIT constructs defined in https://github.com/WebAssembly/component-model/blob/main/design/mvp/WIT.md

/**
 * Functions are defined in an interface or are listed as an import or export from a world.
 * Parameters to a function must all be named and have unique names:
 *
 * ```
 * interface foo {
 *   a1: func()
 *   a2: func(x: u32)
 *   a3: func(y: u64, z: float32)
 * }
 * ```
 *
 * TODO To be refined with imports/exports
 */
object Foo {
    fun a1() {
        TODO()
    }
    fun a2(x: UInt) {
        TODO()
    }
    fun a3(y:ULong, z: Float) {
        TODO()
    }
}

/**
 * Functions can return at most one unnamed type:
 *
 * ```
 * interface bar {
 *   a1: func() -> u32
 *   a2: func() -> string
 * }
 * ```
 *
 * TODO To be refined with imports/exports
 */
object Bar {
    fun a1(): UInt {
        TODO()
    }
    fun a2(): String {
        TODO()
    }
}

/**
 * And functions can also return multiple types by naming them:
 *
 * ```
 * interface baz {
 *   a: func() -> (a: u32, b: float32)
 * }
 * ```
 *
 * TODO To be refined with imports/exports
 */
data class Wrapper(val a: UInt, val b: Float)
object Baz {
    fun a(): Wrapper {
        TODO()
    }
}

/**
 * result
 *
 * ```
 * enum error-code {
 *     too-big,
 *     too-small,
 * }
 * a: func(input: string) -> result<string, error-code>
 * ```
 */
enum class ErrorCode { TOO_BIG, TOO_SMALL }
class CodeException(val code: ErrorCode) : Exception()

fun a(input: String): String {
    if (input.isNotEmpty()) return input
    else throw CodeException(ErrorCode.TOO_SMALL)
}

/**
 * A type statement declares a new named type in the wit document. This name can be later referred to when defining items
 * using this type. This construct is similar to a type alias in other languages.
 *
 * ```
 * type my-awesome-u32 = u32
 * type my-complicated-tuple = tuple<u32, s32, string>
 * ```
 */
typealias myAwesomeUInt = UInt
typealias myComplicatedTuple = Triple<UInt, Int, String>

/**
 * record point {
 *     x: u32,
 *     y: u32,
 * }
 *
 * record person {
 *     name: string,
 *     age: option<u32>,
 */
data class Point(val x: UInt, val y: UInt)
data class Person(val name: String, val age: UInt? = null)

/**
 * A flags represents a bitset structure with a name for each bit. The flags type is represented as a bit flags
 * representation in the canonical ABI.
 *
 * ```
 * flags properties {
 *     lego,
 *     marvel-superhero,
 *     supervillain,
 * }
 * ```
 *
 * TODO Fix typo on supervillain in WIT.md
 * TODO Is it idiomatic to translate WIT flags as data class of Boolean properties?
 */
data class Properties(
    val lego: Boolean = false,
    val marvelSuperhero: Boolean = false,
    val supervillain: Boolean = false
)

/**
 * A variant statement defines a new type where instances of the type match exactly one of the variants listed for the type.
 * This is similar to a "sum" type in algebraic datatypes (or an enum in Rust if you're familiar with it).
 * Variants can be thought of as tagged unions as well.
 *
 * Each case of a variant can have an optional type associated with it which is present when values have that particular
 * case's tag.
 *
 * All variant type must have at least one case specified.
 *
 * ```
 * variant filter {
 *     all,
 *     none,
 *     some(list<string>),
 * }
 * ```
 */
sealed interface Filter {
    object All : Filter
    object None : Filter
    class Some(val value: List<String>): Filter
}

/**
 * An enum statement defines a new type which is semantically equivalent to a variant where none of the cases have a
 * payload type. This is special-cased, however, to possibly have a different representation in the language ABIs or
 * have different bindings generated in for languages.
 *
 * ```
 * enum color {
 *     red,
 *     green,
 *     blue,
 *     yellow,
 *     other,
 * }
 * ```
 */
enum class Color { RED, GREEN, BLUE, YELLOW, OTHER }

/**
 * A union statement defines a new type which is semantically equivalent to a variant where all of the cases have a
 * payload type and the case names are numerical. This is special-cased, however, to have a different representation
 * in the language ABIs or have different bindings generated in for languages.
 *
 * ```
 * union configuration {
 *     string,
 *     list<string>,
 * }
 * ```
 *
 * TODO `union` looks a bit weird in Kotlin, to be validated with the Component Model community group.
 */
sealed interface Configuration {
    class Case1(val value: String): Configuration
    class Case2(val value: List<String>): Configuration
}

/**
 * 'u8' | 'u16' | 'u32' | 'u64'
 */
val u8: UByte = 0u
val u16: UShort = 0u
val u32: UInt = 0u
val u64: ULong = 0u

/**
 * 's8' | 's16' | 's32' | 's64'
 */
val s8: Byte = 0
val s16: Short = 0
val s32: Int = 0
val s64: Long = 0

/**
 * 'float32' | 'float64'
 */
val float32 : Float = 0F
val float64 : Double = 0.0

/**
 * 'char'
 * WIT char is a Unicode Scalar Value, so we need 32-bit Int instead of 16-bit Char
 */
val char: Int = 'a'.code

/**
 * 'bool'
 */
val bool: Boolean = false

/**
 * 'string'
 *
 * May require to define `string-encoding=latin1+utf16`, see
 * https://github.com/WebAssembly/component-model/blob/main/design/mvp/Explainer.md#canonical-definitions for more
 * details.
 */
val string: String = ""

/**
 * tuple<s32, string>
 */
val tuple: Pair<Int, String> = Pair(0, "")

/**
 * list
 *
 * For `Byte`, Kotlin `ByteArray` seems like a better fit (efficiency).
 * Potentially the same apply to types where `*Array` variant is available.
 * For other use cases, let's maybe use Kotlin `List` for now.
 */
val listOfBytes : ByteArray = byteArrayOf()
val list: List<String> = listOf()

/**
 * option<String>
 */
val option: String? = "value"

