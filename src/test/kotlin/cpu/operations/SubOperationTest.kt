package cpu.operations

import org.example.cpu.CPU
import org.example.cpu.operations.SubOperation
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class SubOperationTest {
    private val operation = SubOperation()

    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
    }

    @Test
    fun testSub() {
        CPU.setRegister(1, 5)
        CPU.setRegister(2, 2)
        operation.execute(0x123)
        assertEquals(3, CPU.getRegister(3))
        assertEquals(2, CPU.programCounter)

        CPU.setRegister(1, -5)
        CPU.setRegister(2, 10)
        operation.execute(0x124)
        assertEquals(-15, CPU.getRegister(4))
        assertEquals(4, CPU.programCounter)
    }
}