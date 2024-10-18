package section1.code1

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val lazyJob: Job = launch(start = CoroutineStart.LAZY) {
        println("[${getElapsedTime(startTime)}")
    }
    delay(3000L)
    lazyJob.start()
}

fun getElapsedTime(startTime: Long): String =
    "지난 시간 ${System.currentTimeMillis() - startTime} ms"