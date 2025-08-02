package cpu.operations

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
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
        operation.execute(1, 2, 3)
        assertEquals(8, CPU.getRegister(3))
        assertEquals(2, CPU.programCounter)

        CPU.setRegister(1, -5)
        CPU.setRegister(2, 10)
        operation.execute(1, 2, 4)
        assertEquals(5, CPU.getRegister(4))
        assertEquals(4, CPU.programCounter)
    }

    @Test
    fun testAddNullRegisters() {
        assertFailsWith<IllegalArgumentException> {
            operation.execute(1, null, 3)
        }
        assertFailsWith<IllegalArgumentException> {
            operation.execute(1, 2, null)
        }
    }
}