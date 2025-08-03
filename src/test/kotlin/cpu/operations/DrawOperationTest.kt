package cpu.operations

import org.example.cpu.CPU
import org.example.cpu.operations.DrawOperation
import org.example.display.DisplayData
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DrawOperationTest {
    private lateinit var op: DrawOperation

    @Test
    fun testDraw() {
        CPU.programCounter = 0
        CPU.setRegister(1, 'h'.code)

        val data = 0x125
        DrawOperation().execute(data)

        assertEquals('h', DisplayData.getCharacter(0x2, 0x5))
        assertEquals(2, CPU.programCounter)
    }
}