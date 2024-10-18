package section1.code1

import kotlinx.coroutines.*

fun main() = runBlocking {
    val longJob: Job = launch(Dispatchers.Default) {
        Thread.sleep(1000L)
        println("longJob 코루틴의 동작")
    }

    // longJob.cancel() 캔슬 플레그만 변경
    longJob.cancelAndJoin()
    executeAfterJobCancelled()
}

fun executeAfterJobCancelled() {
    println("longJob 코루틴 최소 후 실행되어야 할 동작")
}