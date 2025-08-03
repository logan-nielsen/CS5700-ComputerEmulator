package cpu

import org.example.cpu.parseAddress
import org.example.cpu.parseByte
import org.example.cpu.parseRegister
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class InstructionParsersTest {
    @Test
    fun `test register parsing at different positions`() {
        val instruction = 0x123
        assertEquals(1, parseRegister(instruction, 1))
        assertEquals(2, parseRegister(instruction, 2))
        assertEquals(3, parseRegister(instruction, 3))
    }

    @Test
    fun `test byte parsing at different positions`() {
        val instruction = 0x123
        assertEquals(0x12, parseByte(instruction, 1))
        assertEquals(0x23, parseByte(instruction, 2))
    }

    @Test
    fun `test address parsing`() {
        assertEquals(0x123, parseAddress(0x4123))
        assertEquals(0xFFF, parseAddress(0xFFF))
        assertEquals(0x000, parseAddress(0x000))
    }

    @Test
    fun `test invalid position throws exception`() {
        val instruction = 0x1234
        assertThrows<IllegalArgumentException> { parseRegister(instruction, 0) }
        assertThrows<IllegalArgumentException> { parseRegister(instruction, 4) }
        assertThrows<IllegalArgumentException> { parseByte(instruction, 0) }
        assertThrows<IllegalArgumentException> { parseByte(instruction, 3) }
    }
}