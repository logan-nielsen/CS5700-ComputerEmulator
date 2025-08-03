package cpu.operations

import org.example.cpu.CPU
import org.example.cpu.operations.SkipNotEqualOperation
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class SkipNotEqualOperationTest {
    private val operation = SkipNotEqualOperation()

    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
    }

    @Test
    fun testSkipNotEqual() {
        CPU.setRegister(1, 5)
        CPU.setRegister(2, 3)
        operation.execute(0x120)
        assertEquals(4, CPU.programCounter)

        CPU.setRegister(1, 5)
        CPU.setRegister(2, 5)
        operation.execute(0x120)
        assertEquals(6, CPU.programCounter)
    }
}