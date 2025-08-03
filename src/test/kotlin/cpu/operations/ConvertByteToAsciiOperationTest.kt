package cpu.operations

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.example.cpu.CPU
import org.example.cpu.operations.ConvertByteToAsciiOperation
import kotlin.test.BeforeTest

class ConvertByteToAsciiOperationTest {
    private val operation = ConvertByteToAsciiOperation()

    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
    }

    @Test
    fun testConvertByteToAscii() {
        // Test numeric values (0-9)
        CPU.setRegister(1, 0)
        operation.execute(0x120)
        assertEquals('0'.code, CPU.getRegister(2))
        assertEquals(2, CPU.programCounter)

        CPU.setRegister(1, 5)
        operation.execute(0x120)
        assertEquals('5'.code, CPU.getRegister(2))
        assertEquals(4, CPU.programCounter)

        // Test hexadecimal values (a-f)
        CPU.setRegister(1, 0xa)
        operation.execute(0x120)
        assertEquals('a'.code, CPU.getRegister(2))
        assertEquals(6, CPU.programCounter)

        CPU.setRegister(1, 0xf)
        operation.execute(0x120)
        assertEquals('f'.code, CPU.getRegister(2))
        assertEquals(8, CPU.programCounter)
    }

    @Test
    fun testInvalidValueGreaterThanF() {
        CPU.setRegister(1, 0x10)
        assertFailsWith<IllegalArgumentException> {
            operation.execute(0x120)
        }
    }
}