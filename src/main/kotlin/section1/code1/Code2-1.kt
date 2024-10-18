package section1.code1

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking(CoroutineName("runBlocking 코루틴")) {
    println("${Thread.currentThread().name}")

    launch(CoroutineName("launch 코루틴")) {
        println("${Thread.currentThread().name}")
    }

    println()
}