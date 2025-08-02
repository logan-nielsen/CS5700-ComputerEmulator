package cpu.operations

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.BeforeTest
import org.example.cpu.CPU
import org.example.cpu.operations.WriteOperation

class WriteOperationTest {
    private val operation = WriteOperation()

    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
    }

    @Test
    fun testWrite() {
        CPU.setRegister(1, 42)
        CPU.address = 5
        operation.execute(1, null, null)
        assertEquals(42, CPU.getRegister(5))
        assertEquals(2, CPU.programCounter)

        CPU.setRegister(2, -15)
        CPU.address = 7
        operation.execute(2, null, null)
        assertEquals(-15, CPU.getRegister(7))
        assertEquals(4, CPU.programCounter)
    }

    @Test
    fun testWriteOnlyUsesFirstRegister() {
        CPU.setRegister(1, 42)
        CPU.address = 5
        operation.execute(1, 2, 3)
        assertEquals(42, CPU.getRegister(5))
        assertEquals(2, CPU.programCounter)
    }
}