package section1.test

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StringStateHolderTest {

    @Test
    fun `updateStringWithDelay(ABC)가 호출되면 문자열이 ABC로 변경된다`() {
        // Given
        val testDispatcher = StandardTestDispatcher()
        val stringStateHolder = StringStateHolder(
            dispatcher =  testDispatcher
        )

        // When
        stringStateHolder.updateStringWithDelay("ABC")

        // Then
        testDispatcher.scheduler.advanceUntilIdle()
        assertEquals("ABC", stringStateHolder.stringState)
    }

    @Test
    fun `backgroundScope를 사용하는 테스트`() = runTest {
        var result = 0

        backgroundScope.launch {
            while(true) {
                delay(1000L)
                result += 1
            }
        }
        advanceTimeBy(1500L)
        assertEquals(1, result)
        advanceTimeBy(1000L)
        assertEquals(2, result)

    }
}