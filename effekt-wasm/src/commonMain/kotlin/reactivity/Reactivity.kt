package reactivity

private typealias Effect = () -> Unit
private typealias Getter<T> = () -> T

/**
 * the current locking mechanism only allows one effect to be running at a time
 */
private var atomicEffect: Effect? = null

/**
 * represents a delegate getter
 */
internal interface Gettable<T> {
    operator fun getValue(thisRef: Any, property: Any?): T = getValue(null, property)
    operator fun getValue(thisRef: Nothing?, property: Any?): T
}

/**
 * represents a delegate setter
 */
internal interface Settable<T> {
    operator fun setValue(thisRef: Any, property: Any?, value: T) = setValue(null, property, value)
    operator fun setValue(thisRef: Nothing?, property: Any?, value: T)
}

/**
 * the most primitive reactive object is a ref, it holds a single value that can only be read.
 * a ref is a dependency that can be subscribed to. The ref will notify all subscribers when it changes.
 */
abstract class Ref<T>: Gettable<T> {
    private val subscribers = HashSet<Effect>()

    protected fun <T> track() {
        atomicEffect?.let { subscribers.add(it) }
    }

    protected fun <T> trigger() {
        /* TODO: de-duplicate effects */
        subscribers.forEach { it() }
    }
}

/**
 * a mutable ref is a ref that can be read and written to
 * @param initial the initial value of the ref
 * @see Ref
 */
class MutableRef<T>(initial: T): Ref<T>(), Settable<T> {
    private var _value = initial
    override operator fun setValue(thisRef: Nothing?, property: Any?, value: T) {
        _value = value
        trigger<T>()
    }

    override operator fun getValue(thisRef: Nothing?, property: Any?): T {
        track<T>()
        return _value
    }
}

/**
 * a computed reactive object is a ref that is computed by a Getter
 * @param getter the getter to compute on
 * @see Getter
 * TODO: add caching of computed values
 */
class Computed<T>(
    private val getter: Getter<T>
) : Ref<T>() {
    override operator fun getValue(thisRef: Nothing?, property: Any?): T {
        track<T>()
        return getter()
    }
}

/**
 * Creates a computed reactive object
 * @param getter the getter to compute on
 */
fun <T> computed(getter: Getter<T>) = Computed(getter)

/**
 * Creates a ref reactive object
 * @param initial the initial value of the ref
 */
fun <T> ref(initial: T) = MutableRef(initial)

/**
 * Watches dependencies and runs the effect when they change.
 * @param update The effect that is run when the dependencies change.
 */
fun watchEffect(update: Effect) {
    lateinit var effect: Effect
    effect = {
        atomicEffect = effect
        update()
        atomicEffect = null
    }

    effect()
}
