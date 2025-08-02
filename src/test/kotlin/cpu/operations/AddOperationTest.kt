package cpu.operations

import kotlin.test.Test
import kotlin.test.assertEquals
import org.example.cpu.CPU
import org.example.cpu.operations.AddOperation
import kotlin.test.BeforeTest

class AddOperationTest {
    private val operation = AddOperation()

    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
    }

    @Test
    fun testAdd() {
        CPU.setRegister(1, 5)
        CPU.setRegister(2, 3)
        operation.execute(0x123)
        assertEquals(8, CPU.getRegister(3))
        assertEquals(2, CPU.programCounter)

        CPU.setRegister(1, -5)
        CPU.setRegister(2, 10)
        operation.execute(0x124)
        assertEquals(5, CPU.getRegister(4))
        assertEquals(4, CPU.programCounter)
    }
}