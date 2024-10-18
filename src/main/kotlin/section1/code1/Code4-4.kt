package section1.code1

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val convertImageJob1: Job = launch(Dispatchers.Default) {
        Thread.sleep(1000L)
        println("[${Thread.currentThread().name}] 이미지1 변환 완료")
    }

    val convertImageJob2: Job = launch(Dispatchers.Default) {
        Thread.sleep(1000L)
        println("[${Thread.currentThread().name}] 이미지2 변환 완료")
    }

    convertImageJob1.join()
    convertImageJob2.join()

    val uploadImageJob: Job = launch(Dispatchers.IO) {
        println("$[${Thread.currentThread().name}] 이미지 1,2 업로드")
    }
}