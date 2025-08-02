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
    fun testJump() {
        CPU.setRegister(1, 10)
        operation.execute(1, null, null)
        assertEquals(10, CPU.programCounter)

        CPU.setRegister(2, 20)
        operation.execute(2, null, null)
        assertEquals(20, CPU.programCounter)
    }
}