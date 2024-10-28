package section1.test

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestCoroutineSchedulerTest {

    @Test
    fun `가상 시간 조절 테스트`() {
        val testCoroutineScheduler = TestCoroutineScheduler()

        testCoroutineScheduler.advanceTimeBy(5000L)
        assertEquals(5000L, testCoroutineScheduler.currentTime)
        testCoroutineScheduler.advanceTimeBy(6000L)
        assertEquals(11000L, testCoroutineScheduler.currentTime)
        testCoroutineScheduler.advanceTimeBy(10000L)
        assertEquals(21000L, testCoroutineScheduler.currentTime)

    }

    @Test
    fun `가상 시간 위에서 테스트 진행`() {
        // Given
        val testCoroutineScheduler: TestCoroutineScheduler = TestCoroutineScheduler()
        val testDispatcher: TestDispatcher = StandardTestDispatcher(scheduler = testCoroutineScheduler)
        val testCoroutineScope = CoroutineScope(context = testDispatcher)

        var result = 0

        testCoroutineScope.launch {
            delay(10000L)
            result = 1
            delay(10000L)
            result = 2
        }

        // Then
        testCoroutineScheduler.advanceTimeBy(5000L)
        assertEquals(0, result)
        testCoroutineScheduler.advanceTimeBy(6000L)
        assertEquals(1, result)
        testCoroutineScheduler.advanceTimeBy(10000L)
        assertEquals(2, result)
    }

    @Test
    fun `advanceUntilIdle의 동작 살펴보기`() {
//        // Given
//        val testCoroutineScope: TestScope = TestScope()
//
//        var result = 0
//
//        // When
//        testCoroutineScope.launch {
//            delay(10_000L)
//            result = 1
//            delay(10_000L)
//            result = 2
//        }
//
//        testCoroutineScope.advanceUntilIdle()
//
//        // Then
//        assertEquals(2, result)

        // Given
        var result = 0

        runTest {
            delay(10000L)
            result = 1
            delay(10000L)
            result = 2
        }
        // Then
        assertEquals(2, result)

    }

    @Test
    fun `runTest로 테스트 감싸기`() = runTest {
        // Given
        var result = 0

        // When
        delay(10000L)
        result = 1
        delay(10000L)
        result = 2

        assertEquals(2, result)
    }

    @Test
    fun `runTest 내부에서 advanceUntilIdle 사용하기`() = runTest {
      var result = 0
      launch {
          delay(1000L)
          result = 1
      }

        println("가상 시간 ${this.currentTime}ms, result = $result")
        advanceUntilIdle()
        println("가상 시간 ${this.currentTime}ms, result = $result")
    }
}
