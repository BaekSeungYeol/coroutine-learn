package section1.code1

import kotlinx.coroutines.*

fun main() = runBlocking {
    val parentJob = launch(Dispatchers.IO) {
        val dbResultsDeferred: List<Deferred<String>> = listOf("db1", "db2", "db3").map {
            async {
                delay(1000L)
                println("${it}로 부터 데이터를 가져오는데 성공했습니다.")
                return@async "[${it}]data"
            }
        }
        val dbResults: List<String> = dbResultsDeferred.awaitAll()

        println(dbResults)
    }

    parentJob.cancel()
}