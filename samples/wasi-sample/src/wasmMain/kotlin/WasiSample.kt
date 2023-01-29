/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import kotlinx.datetime.Clock
import org.kowasm.wasi.*
import kotlin.random.Random

fun main() {
    Wasi.println("Hello, world!")

    Wasi.println(Clock.System.now().toString())

    Wasi.createDirectory("testDir")
    Wasi.createFile("testFile")
    Wasi.listDirectoryEntries(".").forEach(Wasi::println)

    val pseudoGenerator = SeededWasiRandom()
    Wasi.println("Pseudo random number generator")
    Wasi.println(pseudoGenerator.nextLong().toString())
    Wasi.println(pseudoGenerator.nextLong().toString())

    val secureGenerator = SecureWasiRandom()
    Wasi.println("Secure random number generator")
    Wasi.println(secureGenerator.nextLong().toString())
    Wasi.println(secureGenerator.nextLong().toString())
}
