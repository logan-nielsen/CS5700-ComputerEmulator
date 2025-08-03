package cpu

import org.example.cpu.CPU
import org.example.memory.MemoryType
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class CPUTest {
    @BeforeTest
    fun setup() {
        CPU.programCounter = 0
        CPU.timer = 0
        CPU.address = 0
        CPU.memoryType = MemoryType.RAM
        for (i in 0..7) {
            CPU.setRegister(i, 0)
        }
    }

    @Test
    fun testRegisterOperations() {
        CPU.setRegister(0, 42)
        assertEquals(42, CPU.getRegister(0))

        CPU.setRegister(7, 255)
        assertEquals(255, CPU.getRegister(7))
    }

    @Test
    fun testTimerOperations() {
        CPU.timer = 10
        CPU.decrementTimer()
        assertEquals(9, CPU.timer)

        repeat(9) { CPU.decrementTimer() }
        assertEquals(0, CPU.timer)
    }

    @Test
    fun testProgramCounter() {
        CPU.programCounter = 0
        CPU.incrementProgramCounter()
        assertEquals(2, CPU.programCounter)

        CPU.incrementProgramCounter(2)
        assertEquals(6, CPU.programCounter)
    }

    @Test
    fun testROMLoading() {
        val testROM = intArrayOf(0xFF, 0xEE, 0xDD, 0xCC)
        CPU.loadROM(testROM)
        CPU.start()
        CPU.pause()
    }

    @Test
    fun testStop() {
        CPU.stop()
        assertTrue(CPU.executor.isShutdown)
    }

    @Test
    fun testInvalidProgramCounter() {
        assertFailsWith<IllegalArgumentException> {
            CPU.programCounter = 3
        }
    }

    @Test
    fun testInvalidTimer() {
        assertFailsWith<IllegalArgumentException> {
            CPU.timer = -1
        }
    }

    @Test
    fun testInvalidAddress() {
        assertFailsWith<IllegalArgumentException> {
            CPU.address = -1
        }
    }
}