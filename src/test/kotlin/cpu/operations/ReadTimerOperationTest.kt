package cpu.operations

import kotlin.test.Test
import kotlin.test.assertEquals
import org.example.cpu.CPU
import org.example.cpu.operations.ReadTimerOperation
import kotlin.test.BeforeTest

class ReadTimerOperationTest {
    private val operation = ReadTimerOperation()

    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
    }

    @Test
    fun testReadTimer() {
        CPU.timer = 42
        operation.execute(1, null, null)
        assertEquals(42, CPU.getRegister(1))
        assertEquals(2, CPU.programCounter)

        CPU.timer = 100
        operation.execute(2, null, null)
        assertEquals(100, CPU.getRegister(2))
        assertEquals(4, CPU.programCounter)
    }
}