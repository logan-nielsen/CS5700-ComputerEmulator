package cpu.operations

import org.example.cpu.CPU
import org.example.cpu.operations.ConvertToBase10Operation
import org.example.memory.ComputerMemory
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ConvertToBase10OperationTest {
    private val operation = ConvertToBase10Operation()

    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
    }

    @Test
    fun testConvertToBase10() {
        CPU.setRegister(1, 0x2A)
        operation.execute(0x100)

        assertEquals(0, ComputerMemory.getMemory(CPU.memoryType).read(CPU.address))
        assertEquals(4, ComputerMemory.getMemory(CPU.memoryType).read(CPU.address + 1))
        assertEquals(2, ComputerMemory.getMemory(CPU.memoryType).read(CPU.address + 2))
        assertEquals(2, CPU.programCounter)
    }
}