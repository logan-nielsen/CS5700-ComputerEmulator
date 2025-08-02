package cpu.operations

import kotlin.test.Test
import kotlin.test.assertEquals
import org.example.cpu.CPU
import org.example.cpu.operations.ConvertToBase10Operation
import org.example.memory.ComputerMemory
import kotlin.test.BeforeTest

class ConvertToBase10OperationTest {
    private val operation = ConvertToBase10Operation()

    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
    }

    @Test
    fun testConvertToBase10() {
        CPU.setRegister(1, 0x2A)
        operation.execute(1, null, null)

        assertEquals('4'.code, ComputerMemory.getMemory(CPU.memoryType).read(CPU.address))
        assertEquals('2'.code, ComputerMemory.getMemory(CPU.memoryType).read(CPU.address + 1))
        assertEquals(2, CPU.programCounter)
    }

    @Test
    fun testConvertToBase10MultiDigit() {
        CPU.setRegister(2, 0x3039)
        operation.execute(2, null, null)

        assertEquals('1'.code, ComputerMemory.getMemory(CPU.memoryType).read(CPU.address))
        assertEquals('2'.code, ComputerMemory.getMemory(CPU.memoryType).read(CPU.address + 1))
        assertEquals('3'.code, ComputerMemory.getMemory(CPU.memoryType).read(CPU.address + 2))
        assertEquals('4'.code, ComputerMemory.getMemory(CPU.memoryType).read(CPU.address + 3))
        assertEquals('5'.code, ComputerMemory.getMemory(CPU.memoryType).read(CPU.address + 4))
        assertEquals(2, CPU.programCounter)
    }
}