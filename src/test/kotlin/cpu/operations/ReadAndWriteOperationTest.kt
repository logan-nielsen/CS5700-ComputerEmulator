package cpu.operations

import kotlin.test.Test
import kotlin.test.assertEquals
import org.example.cpu.CPU
import org.example.cpu.operations.ReadOperation
import org.example.cpu.operations.WriteOperation
import org.example.memory.MemoryType
import kotlin.test.BeforeTest

class ReadAndWriteOperationTest {
    private val readOperation = ReadOperation()
    private val writeOperation = WriteOperation()

    @BeforeTest
    fun setUp() {
        CPU.programCounter = 0
    }

    @Test
    fun testReadAndWrite() {
        CPU.address = 1
        CPU.memoryType = MemoryType.RAM

        CPU.setRegister(1, 42)
        writeOperation.execute(0x100)
        readOperation.execute(0x200)
        assertEquals(42, CPU.getRegister(2))
        assertEquals(4, CPU.programCounter)
    }
}