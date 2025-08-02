package cpu.operations

import kotlin.test.Test
import kotlin.test.assertEquals
import org.example.cpu.CPU
import org.example.cpu.operations.SetTimerOperation
import kotlin.test.BeforeTest

class SetTimerOperationTest {
    private val operation = SetTimerOperation()

    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
        CPU.timer = 0
    }

    @Test
    fun testSetTimer() {
        operation.execute(5, null, null)
        assertEquals(5, CPU.timer)
        assertEquals(2, CPU.programCounter)

        operation.execute(10, null, null)
        assertEquals(10, CPU.timer)
        assertEquals(4, CPU.programCounter)
    }
}