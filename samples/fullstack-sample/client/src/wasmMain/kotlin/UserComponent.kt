import kotlinx.browser.window
import org.w3c.dom.Element
import org.w3c.dom.HTMLInputElement
import reactivity.computed
import reactivity.ref
import reactivity.watchEffect

class UserComponent(private val root: Element) {

    private val nameInput = root.getElementByClassName("name") as HTMLInputElement
    private val ageInput = root.getElementByClassName("age") as HTMLInputElement

    private var user by ref(User(nameInput.value, ageInput.value.toInt()))

    init {
        val message by computed { "Hello! My name is <mark>${user.name}</mark>. I'm <mark>${user.age}</mark> years old." }
        watchEffect {
            root.getElementByClassName("message").innerHTML = message
        }

        nameInput.onkeyup = {
            updateUserIfValid(user.copy(name = nameInput.value))
            null // See https://youtrack.jetbrains.com/issue/KT-57058
        }

        ageInput.onkeyup = {
            updateUserIfValid(user.copy(age = ageInput.value.toInt()))
            null // See https://youtrack.jetbrains.com/issue/KT-57058
        }
    }

    private fun updateUserIfValid(updatedUser: User) {
        val result = updatedUser.validate()
        if (result.errors.isEmpty()) {
            user = updatedUser
        }
        else {
            window.alert(result.errors.joinToString("\n"))
        }
    }
}
