package section1.code1

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    launch(CoroutineName("Coroutine1")) {
        launch(CoroutineName("Coroutine3")) {
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
        println(this.coroutineContext[Job])
        CoroutineScope(Dispatchers.IO).launch(CoroutineName("Coroutine4")) {
            println("launch 코루틴의 parentJob: ${this.coroutineContext[Job]?.parent}")
        }
        launch(CoroutineName("Coroutine4")) {
            println("launch 코루틴의 parentJob: ${this.coroutineContext[Job]?.parent}")
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }

    launch(CoroutineName("Coroutine2")) {
        println("[${Thread.currentThread().name}] 코루틴 실행")
    }
}