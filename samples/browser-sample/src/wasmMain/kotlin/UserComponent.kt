import kotlinx.browser.window
import kotlinx.html.dom.append
import kotlinx.html.h3
import kotlinx.html.input
import kotlinx.html.js.onKeyUpFunction
import kotlinx.html.p
import org.w3c.dom.Element
import org.w3c.dom.HTMLInputElement
import reactivity.computed
import reactivity.ref
import reactivity.watchEffect

class UserComponent(initialUser: User, private val root: Element) {

    private var user by ref(initialUser)

    init {
        render()
        val message by computed { "Hello! My name is <mark>${user.name}</mark>. I'm <mark>${user.age}</mark> years old." }
        watchEffect {
            root.getElementByClassName("message").innerHTML = message
        }
    }

    private fun render() {
        root.append {
            h3("message")
            p {
                +"Edit person's name "
                input {
                    value = user.name
                    onKeyUpFunction = {
                        updateUserIfValid(user.copy(name = (it.target as HTMLInputElement).value))
                    }
                }
                +" and age "
                input {
                    value = user.age.toString()
                    onKeyUpFunction = {
                        updateUserIfValid(user.copy(age = (it.target as HTMLInputElement).value.toInt()))
                    }
                }
            }
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
