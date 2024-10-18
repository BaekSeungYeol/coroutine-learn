package section1.code1

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val updateTokenJob = launch(Dispatchers.IO) {
        println(" 1 [${Thread.currentThread().name}")
        delay(100L)
        println(" 2 [${Thread.currentThread().name}")
    }

    updateTokenJob.join()
    val networkCallJob = launch(Dispatchers.IO) {
        println(" 3 [${Thread.currentThread().name}")
    }
}