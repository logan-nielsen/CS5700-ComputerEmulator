package cpu.operations

import org.example.cpu.CPU
import org.example.cpu.operations.StoreOperation
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class StoreOperationTest {
    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
    }

    @Test
    fun testStore() {
        val operation = StoreOperation()
        operation.execute(0x142)
        assertEquals(0x42, CPU.getRegister(1))
        assertEquals(2, CPU.programCounter)

        operation.execute(0x200)
        assertEquals(0, CPU.getRegister(2))
        assertEquals(4, CPU.programCounter)

        operation.execute(0x126)
        assertEquals(0x26, CPU.getRegister(1))
    }
}