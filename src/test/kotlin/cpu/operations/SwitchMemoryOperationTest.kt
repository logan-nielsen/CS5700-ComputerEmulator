package cpu.operations

import kotlin.test.Test
import kotlin.test.assertEquals
import org.example.cpu.CPU
import org.example.cpu.operations.SwitchMemoryOperation
import org.example.memory.MemoryType
import kotlin.test.BeforeTest

class SwitchMemoryOperationTest {
    private val operation = SwitchMemoryOperation()

    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
        CPU.memoryType = MemoryType.RAM
    }

    @Test
    fun testSwitchFromRamToRom() {
        operation.execute(0, null, null)
        assertEquals(MemoryType.ROM, CPU.memoryType)
        assertEquals(2, CPU.programCounter)
    }

    @Test
    fun testSwitchFromRomToRam() {
        CPU.memoryType = MemoryType.ROM
        operation.execute(0, null, null)
        assertEquals(MemoryType.RAM, CPU.memoryType)
        assertEquals(2, CPU.programCounter)
    }
}