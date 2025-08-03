package memory

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.example.memory.ROM

class ROMTest {
    @Test
    fun testReadData() {
        val rom = ROM(2)
        rom.load(intArrayOf(42, 24))
        assertEquals(42, rom.read(0))
        assertEquals(24, rom.read(1))
    }

    @Test
    fun testLoadData() {
        val rom = ROM(3)
        rom.load(intArrayOf(1, 2, 3))
        assertEquals(1, rom.read(0))
        assertEquals(2, rom.read(1))
        assertEquals(3, rom.read(2))
    }

    @Test
    fun testWriteShouldThrowException() {
        val rom = ROM(1)
        assertFailsWith<Exception> {
            rom.write(0, 42)
        }
    }
}