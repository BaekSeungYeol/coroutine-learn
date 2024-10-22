package section1.code1

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val coroutineContext = newSingleThreadContext("MyThread") + CoroutineName("ParentCoroutine")
    launch(coroutineContext) {
        println("[${Thread.currentThread().name}]")
        launch(CoroutineName("ChildCoroutine")) {
            println("[${Thread.currentThread().name}]")
        }
    }
}