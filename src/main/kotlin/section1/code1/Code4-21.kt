package section1.code1

import kotlinx.coroutines.*

fun main() = runBlocking<Unit>{
    val coroutineContext = newSingleThreadContext("MyThread") + CoroutineName("MyCoroutine")

    launch(context = coroutineContext) {
        println("[${Thread.currentThread().name}] Start")
    }

    val nameFromContext = coroutineContext[CoroutineName.Key]
    println(coroutineContext)

    val disPatcherFromContext = coroutineContext[Dispatchers.IO.key]

    println(disPatcherFromContext)

}