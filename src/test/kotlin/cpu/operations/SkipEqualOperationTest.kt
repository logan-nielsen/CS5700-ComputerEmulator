package cpu.operations

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.example.cpu.CPU
import org.example.cpu.operations.SkipEqualOperation
import kotlin.test.BeforeTest

class SkipEqualOperationTest {
    private val operation = SkipEqualOperation()

    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
    }

    @Test
    fun testSkipEqual() {
        CPU.setRegister(1, 5)
        CPU.setRegister(2, 5)
        operation.execute(1, 2, null)
        assertEquals(4, CPU.programCounter)

        CPU.programCounter = 0
        CPU.setRegister(1, 10)
        CPU.setRegister(2, 10)
        operation.execute(1, 2, null)
        assertEquals(4, CPU.programCounter)
    }

    @Test
    fun testSkipNotEqual() {
        CPU.setRegister(1, 5)
        CPU.setRegister(2, 3)
        operation.execute(1, 2, null)
        assertEquals(2, CPU.programCounter)

        CPU.programCounter = 0
        CPU.setRegister(1, -5)
        CPU.setRegister(2, 10)
        operation.execute(1, 2, null)
        assertEquals(2, CPU.programCounter)
    }

    @Test
    fun testSkipEqualNullRegister() {
        assertFailsWith<IllegalArgumentException> {
            operation.execute(1, null, null)
        }
    }
}