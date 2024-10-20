package section1.code1

import kotlinx.coroutines.*

fun main() = runBlocking {
    val whileJob: Job = launch(Dispatchers.Default) {
        while(true) {
            println("작업 중")
            yield()
        }
    }
    delay(100L)
    whileJob.cancel()
}