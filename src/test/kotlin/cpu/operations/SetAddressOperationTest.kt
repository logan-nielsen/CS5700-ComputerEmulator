package cpu.operations

import org.example.cpu.CPU
import org.example.cpu.operations.SetAddressOperation
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class SetAddressOperationTest {
    private val operation = SetAddressOperation()

    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
        CPU.address = 0
    }

    @Test
    fun testSetAddress() {
        operation.execute(0x421)
        assertEquals(0x421, CPU.address)
        assertEquals(2, CPU.programCounter)

        operation.execute(0x100)
        assertEquals(0x100, CPU.address)
        assertEquals(4, CPU.programCounter)
    }
}