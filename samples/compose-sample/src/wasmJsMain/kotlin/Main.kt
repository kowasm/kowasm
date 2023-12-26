import androidx.compose.runtime.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

fun main() {
	fun greet() = listOf("Hello", "Hallo", "Hola", "Servus").random()

	renderComposable("greeting") {
		var greeting by remember { mutableStateOf(greet()) }
		Button(attrs = { onClick { greeting = greet() } }) {
			Text(greeting)
		}
	}
}