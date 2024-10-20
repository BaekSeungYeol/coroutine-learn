package section1.code1

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking {
    val result = withContext(Dispatchers.IO) {
        delay(1000L)
        "결과값"
    }

    println(result)
}