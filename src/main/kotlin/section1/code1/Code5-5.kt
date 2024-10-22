package section1.code1

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val parentJob = launch {
        launch {
            delay(1000L)
            println("[${getElapsedTime(startTime)}")
        }
        println("[${getElapsedTime(startTime)}")
    }
    parentJob.invokeOnCompletion {
        println("[${getElapsedTime(startTime)}")
    }
    delay(500L)
    println(parentJob)
}
