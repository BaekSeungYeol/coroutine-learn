package section1.code1

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch(Dispatchers.Default) {
        while(this.isActive) {
            println("작업 중")
        }
    }
    delay(100L)
    job.cancel()
}