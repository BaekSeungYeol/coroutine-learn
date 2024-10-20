package section1.code1

import kotlinx.coroutines.*

fun main() = runBlocking {

    // COMPLETED
//    val job: Job = launch(start = CoroutineStart.LAZY) {
//        delay(1000L)
//    }
//    job.join()
//    println(job)

    // CANCELED
    val whileJob: Job = launch(Dispatchers.IO) {
        while (true) {
            yield()
        }
    }
    whileJob.cancelAndJoin()
    println(whileJob)
}