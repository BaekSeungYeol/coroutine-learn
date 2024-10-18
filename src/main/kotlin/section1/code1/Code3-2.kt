package section1.code1

import kotlinx.coroutines.*

val multiThreadDispatcher: CoroutineDispatcher =
    newFixedThreadPoolContext(2, "MultiThread")

fun main() = runBlocking<Unit> {
    launch(multiThreadDispatcher) {
        println("${Thread.currentThread().name} 실행")
    }

    launch(multiThreadDispatcher) {
        println("${Thread.currentThread().name} 실행")
    }
}