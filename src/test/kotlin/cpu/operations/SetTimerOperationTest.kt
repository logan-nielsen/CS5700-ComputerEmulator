package cpu.operations

import org.example.cpu.CPU
import org.example.cpu.operations.SetTimerOperation
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class SetTimerOperationTest {
    private val operation = SetTimerOperation()

    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
        CPU.timer = 0
    }

    @Test
    fun testSetTimer() {
        operation.execute(0x050)
        assertEquals(0x05, CPU.timer)
        assertEquals(2, CPU.programCounter)

        operation.execute(0xff0)
        assertEquals(0xff, CPU.timer)
        assertEquals(4, CPU.programCounter)
    }
}