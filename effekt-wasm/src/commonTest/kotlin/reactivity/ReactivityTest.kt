package reactivity

import kotlin.test.Test
import kotlin.test.assertEquals

class ReactivityTest {

    @Test
    fun testSumOfRefByComputed() {
        var a by ref(2)
        var b by ref(3)
        val c by computed { a + b }

        var cache = 0

        watchEffect {
            cache = c
            println("c = $c")
        }

        assertEquals(5, c)
        assertEquals(5, cache)
        a = 3
        assertEquals(6, c)
        assertEquals(6, cache)
        b = 4
        assertEquals(7, c)
        assertEquals(7, cache)
    }

    @Test
    fun testRef() {
        var a by ref(0)

        a += 1
        assertEquals(1, a)
        a = 2
        assertEquals(2, a)
        a *= 2
        assertEquals(4, a)
    }
}