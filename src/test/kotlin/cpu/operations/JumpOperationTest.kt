package cpu.operations

import kotlin.test.Test
import kotlin.test.assertEquals
import org.example.cpu.CPU
import org.example.cpu.operations.JumpOperation
import kotlin.test.BeforeTest

class JumpOperationTest {
    private val operation = JumpOperation()

    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
    }

    @Test
    fun testJumpToInvalidAddress() {
        kotlin.test.assertFailsWith<IllegalArgumentException> {
            operation.execute(0x101)
        }
    }

    @Test
    fun testJump() {
        CPU.setRegister(1, 10)
        operation.execute(0x100)
        assertEquals(0x100, CPU.programCounter)

        CPU.setRegister(2, 20)
        operation.execute(0x200)
        assertEquals(0x200, CPU.programCounter)
    }
}