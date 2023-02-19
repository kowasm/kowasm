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

fun main() {
    print()
    clock()
    random()
    filesystem()
    cli()
}

private fun print() {
    Wasi.out.println("== Print ==")

    Wasi.out.println("Hello, world!")
    Wasi.err.println("Error")
}

private fun clock() {
    Wasi.out.println("\n== Clock ==")

    val now = Clock.System.now()
    Wasi.out.println(now)
}

private fun filesystem() {
    Wasi.out.println("\n== Filesystem ==")

    Wasi.createDirectoryAt(StandardDescriptor.FIRST_PREOPEN,"testDir")
    val descriptor = Wasi.openAt(
        StandardDescriptor.FIRST_PREOPEN,
        "testFile",
        OpenFlags(create = true),
        DescriptorFlags(read = true, write = true)
    )
    val content = "Hello, file!"
    Wasi.write(descriptor, content.encodeToByteArray())
    val readResult = Wasi.read(descriptor, content.length.toULong())
    Wasi.out.println(readResult.first.decodeToString())
    Wasi.readDirectory(StandardDescriptor.FIRST_PREOPEN,".").forEach { Wasi.out.println(it) }
}

private fun random() {
    Wasi.out.println("\n== Random ==")

    val pseudoGenerator = SeededWasiRandom()
    Wasi.out.println("Pseudo random number generator")
    Wasi.out.println(pseudoGenerator.nextLong())
    Wasi.out.println(pseudoGenerator.nextLong())

    val secureGenerator = SecureWasiRandom()
    Wasi.out.println("Secure random number generator")
    Wasi.out.println(secureGenerator.nextLong())
    Wasi.out.println(secureGenerator.nextLong())
}

private fun cli() {
    Wasi.out.println("\n== CLI ==")

    Wasi.args.forEach { Wasi.out.println(it) }
    Wasi.envVars.forEach { Wasi.out.println(it) }
}
