package cpu.operations

import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkAll
import org.example.cpu.CPU
import org.example.cpu.operations.ReadKeyboardOperation
import org.example.display.userinput.ConsoleUserInput
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ReadKeyboardOperationTest {
    private lateinit var operation: ReadKeyboardOperation

    @BeforeTest
    fun setUp() {
        operation = ReadKeyboardOperation()
        mockkObject(ConsoleUserInput)
    }

    @AfterTest
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun testEmptyInput() {
        every { ConsoleUserInput.get() } returns ""

        operation.execute(0x100)
        val result = CPU.getRegister(1)
        assertEquals(0x0, result)
    }

    @Test
    fun testSimpleInput() {
        every { ConsoleUserInput.get() } returns "AB"

        operation.execute(0x100)
        val result = CPU.getRegister(1)
        assertEquals(0xab, result)
    }

    @Test
    fun testLongInputTruncate() {
        every { ConsoleUserInput.get() } returns "FFFF"

        operation.execute(0x200)
        val result = CPU.getRegister(2)
        assertEquals(0xff, result)
    }
}