package cpu.operations

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.example.cpu.CPU
import org.example.cpu.operations.StoreOperation
import kotlin.test.BeforeTest

class StoreOperationTest {
    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
    }

    @Test
    fun testStore() {
        val operation = StoreOperation()
        operation.execute(42, 1, null)
        assertEquals(42, CPU.getRegister(1))
        assertEquals(2, CPU.programCounter)

        operation.execute(0, 2, null)
        assertEquals(0, CPU.getRegister(2))
        assertEquals(4, CPU.programCounter)

        operation.execute(-26, 1, null)
        assertEquals(-26, CPU.getRegister(1))
    }

    @Test
    fun testStoreNullRegister() {
        val operation = StoreOperation()
        assertFailsWith<IllegalArgumentException> {
            operation.execute(42, null, null)
        }
    }
}