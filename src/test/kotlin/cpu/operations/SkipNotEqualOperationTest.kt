package cpu.operations

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.example.cpu.CPU
import org.example.cpu.operations.SkipNotEqualOperation
import kotlin.test.BeforeTest

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
        operation.execute(1, 2, null)
        assertEquals(4, CPU.programCounter)

        CPU.setRegister(1, 5)
        CPU.setRegister(2, 5)
        operation.execute(1, 2, null)
        assertEquals(6, CPU.programCounter)
    }

    @Test
    fun testSkipNotEqualNullRegister() {
        assertFailsWith<IllegalArgumentException> {
            operation.execute(1, null, null)
        }
    }
}