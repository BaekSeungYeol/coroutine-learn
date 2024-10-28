package section1.test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AddUseCaseTest {

    @Test
    fun `1,2,3을 더하면 6이다`() {
        val addUseCase = AddUseCase()
        val result = addUseCase.add(1,2,3)
        assertEquals(6, result)
    }

    @Test
    fun `실패하는 테스트_1,2,3을 더하면 5이다`() {
        val addUseCase = AddUseCase()
        val result = addUseCase.add(1,2,3)
        assertEquals(5,result)
    }
}

