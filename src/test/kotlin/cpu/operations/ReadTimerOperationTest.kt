package cpu.operations

import org.example.cpu.CPU
import org.example.cpu.operations.ReadTimerOperation
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ReadTimerOperationTest {
    private val operation = ReadTimerOperation()

    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
    }

    @Test
    fun testReadTimer() {
        CPU.timer = 42
        operation.execute(0x100)
        assertEquals(42, CPU.getRegister(1))
        assertEquals(2, CPU.programCounter)

        CPU.timer = 100
        operation.execute(0x200)
        assertEquals(100, CPU.getRegister(2))
        assertEquals(4, CPU.programCounter)
    }
}