package cpu.operations

import kotlin.test.Test
import kotlin.test.assertEquals
import org.example.cpu.CPU
import org.example.cpu.operations.SetAddressOperation
import kotlin.test.BeforeTest

class SetAddressOperationTest {
    private val operation = SetAddressOperation()

    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
        CPU.address = 0
    }

    @Test
    fun testSetAddress() {
        operation.execute(42, null, null)
        assertEquals(42, CPU.address)
        assertEquals(2, CPU.programCounter)

        operation.execute(100, null, null)
        assertEquals(100, CPU.address)
        assertEquals(4, CPU.programCounter)
    }
}