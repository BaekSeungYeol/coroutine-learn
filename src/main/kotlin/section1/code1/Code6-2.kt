package section1.code1

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch(start = CoroutineStart.ATOMIC) {
        println("작업1")
    }
    job.cancel()
    println("작업2")
}