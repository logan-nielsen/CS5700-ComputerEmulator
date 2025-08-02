package cpu.operations

import kotlin.test.Test
import kotlin.test.assertEquals
import org.example.cpu.CPU
import org.example.cpu.operations.ReadOperation
import kotlin.test.BeforeTest

class ReadOperationTest {
    private val operation = ReadOperation()

    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
    }

    @Test
    fun testRead() {
        CPU.address = 1
        CPU.setRegister(1, 10)
        operation.execute(2, null, null)
        assertEquals(10, CPU.getRegister(2))
        assertEquals(2, CPU.programCounter)

        CPU.address = 2
        CPU.setRegister(2, 20)
        operation.execute(3, null, null)
        assertEquals(20, CPU.getRegister(3))
        assertEquals(4, CPU.programCounter)
    }
}