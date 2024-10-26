package section1.code1

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

var count = 0

// 1. MUTEX
// 2. single Thread Dispatchers.Default.limitedParallelism(1)
fun main() = runBlocking {
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            launch {
                count++
            }
        }
    }
    println("count = $count")
}