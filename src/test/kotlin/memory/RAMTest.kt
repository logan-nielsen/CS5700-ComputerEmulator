package memory

import kotlin.test.Test
import kotlin.test.assertEquals
import org.example.memory.RAM

class RAMTest {
    @Test
    fun testWriteAndReadData() {
        val ram = RAM(2)
        ram.write(0, 42)
        assertEquals(42, ram.read(0))
    }

    @Test
    fun testMultipleWrites() {
        val ram = RAM(3)
        ram.write(0, 1)
        ram.write(1, 2)
        ram.write(2, 3)
        assertEquals(1, ram.read(0))
        assertEquals(2, ram.read(1))
        assertEquals(3, ram.read(2))
    }

    @Test
    fun testWriteAtBoundaries() {
        val ram = RAM(4)
        ram.write(0, 10)     // First address
        ram.write(3, 40)     // Last address
        assertEquals(10, ram.read(0))
        assertEquals(40, ram.read(3))
    }
}