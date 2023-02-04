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
 */
interface Foo {
    fun a1()
    fun a2(x: UInt)
    fun a3(y:ULong, z: Float)
}

/**
 * Functions can return at most one unnamed type:
 *
 * ```
 * interface foo {
 *   a1: func() -> u32
 *   a2: func() -> string
 * }
 * ```
 */
interface FooWithReturnValue {
    fun a1(): UInt
    fun a2(): String
}

/**
 * And functions can also return multiple types by naming them:
 *
 * ```
 * interface foo {
 *   a: func() -> (a: u32, b: float32)
 * }
 * ```
 *
 * TODO Confirm this pattern requires the creation of a dedicated data class since return values are named
 * TODO How Kotlin properties mutability should be inferred from WIT?
 */
data class MultipleReturnValue(val a: UInt, val b: Float)
interface FooWithMultipleReturnValue {
    fun a(): MultipleReturnValue
}

/**
 * result
 *
 *
 * ```
 * enum errno {
 *     too-big,
 *     too-small,
 *     too-fast,
 *     too-slow,
 * }
 * a: func(input: string) -> result<string, errno>
 * ```
 *
 * TODO Does it translate to regular return value + Exception thrown for most use cases?
 */
enum class Errno { TOO_BIG, TOO_SMALL, TOO_FAST, TOO_SLOW }
class Err(val code: Errno) : Exception()
fun a(input: String): String {
    if (input.isNotEmpty()) {
        return input
    }
    else {
        throw Err(Errno.TOO_SMALL)
    }
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
 * A record statement declares a new named structure with named fields. Records are similar to a struct in many languages.
 * Instances of a record always have their fields defined.
 *
 * ```
 * record pair {
 *     x: u32,
 *     y: u32,
 * }
 *
 * record person {
 *     name: string,
 *     age: u32,
 *     has-lego-action-figure: bool,
 * }
 * ```
 *
 * TODO How Kotlin properties mutability should be inferred from WIT?
 */
data class ReadOnlyPair(val x: UInt, val y: UInt)
data class MutablePair(var x: UInt, var y: UInt)
data class ReadOnlyPerson(val name: String, val age: UInt, val hasLegoActionFigure: Boolean)
data class MutablePerson(var name: String, var age: UInt, var hasLegoActionFigure: Boolean)

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
 * TODO How Kotlin properties mutability should be inferred from WIT?
 * TODO Is it idiomatic to translate WIT flags as data class of Boolean properties?
 */
data class ReadOnlyProperties(val lego: Boolean, val marvelSuperhero: Boolean, val supervillain: Boolean)
data class MutableProperties(var lego: Boolean, var marvelSuperhero: Boolean, var supervillain: Boolean)

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
sealed interface Filter
sealed class All : Filter
sealed class None : Filter
sealed class Some(list: List<String>): Filter

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
 * TODO How WIT union should translate to Kotlin?
 */

/**
 * 'u8' | 'u16' | 'u32' | 'u64'
 */
val u8: UByte = 0u
val u16: UShort = 0u
val u32: UInt = 0u
val u64: UInt = 0u

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
 */
val char: Char = 'a'

/**
 * 'bool'
 */
val bool: Boolean = false

/**
 * 'string'
 */
val string: String = ""

/**
 * tuple
 */
val tuple: Pair<Int, String> = Pair(0, "")

/**
 * list
 */
val list: List<String> = listOf()

/**
 * option
 */
val option: String? = ""
