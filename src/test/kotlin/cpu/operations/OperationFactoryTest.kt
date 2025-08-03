package cpu.operations

import org.example.cpu.operations.AddOperation
import org.example.cpu.operations.ConvertByteToAsciiOperation
import org.example.cpu.operations.ConvertToBase10Operation
import org.example.cpu.operations.DrawOperation
import org.example.cpu.operations.JumpOperation
import org.example.cpu.operations.OperationFactory
import org.example.cpu.operations.ReadKeyboardOperation
import org.example.cpu.operations.ReadOperation
import org.example.cpu.operations.ReadTimerOperation
import org.example.cpu.operations.SetAddressOperation
import org.example.cpu.operations.SetTimerOperation
import org.example.cpu.operations.SkipEqualOperation
import org.example.cpu.operations.SkipNotEqualOperation
import org.example.cpu.operations.StopOperation
import org.example.cpu.operations.StoreOperation
import org.example.cpu.operations.SubOperation
import org.example.cpu.operations.SwitchMemoryOperation
import org.example.cpu.operations.WriteOperation
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertIs

class OperationFactoryTest {
    @Test
    fun createStop() {
        val operation = OperationFactory.create(0x000)
        assertIs<StopOperation>(operation)
    }

    @Test
    fun createStore() {
        val operation = OperationFactory.create(0x0123)
        assertIs<StoreOperation>(operation)
    }

    @Test
    fun createAdd() {
        val operation = OperationFactory.create(0x1123)
        assertIs<AddOperation>(operation)
    }

    @Test
    fun createSub() {
        val operation = OperationFactory.create(0x2123)
        assertIs<SubOperation>(operation)
    }

    @Test
    fun createRead() {
        val operation = OperationFactory.create(0x3123)
        assertIs<ReadOperation>(operation)
    }

    @Test
    fun createWrite() {
        val operation = OperationFactory.create(0x4123)
        assertIs<WriteOperation>(operation)
    }

    @Test
    fun createJump() {
        val operation = OperationFactory.create(0x5123)
        assertIs<JumpOperation>(operation)
    }

    @Test
    fun createReadKeyboard() {
        val operation = OperationFactory.create(0x6123)
        assertIs<ReadKeyboardOperation>(operation)
    }

    @Test
    fun createSwitchMemory() {
        val operation = OperationFactory.create(0x7123)
        assertIs<SwitchMemoryOperation>(operation)
    }

    @Test
    fun createSkipEqual() {
        val operation = OperationFactory.create(0x8123)
        assertIs<SkipEqualOperation>(operation)
    }

    @Test
    fun createSkipNotEqual() {
        val operation = OperationFactory.create(0x9123)
        assertIs<SkipNotEqualOperation>(operation)
    }

    @Test
    fun createSetAddress() {
        val operation = OperationFactory.create(0xa123)
        assertIs<SetAddressOperation>(operation)
    }

    @Test
    fun createSetTimer() {
        val operation = OperationFactory.create(0xb123)
        assertIs<SetTimerOperation>(operation)
    }

    @Test
    fun createReadTimer() {
        val operation = OperationFactory.create(0xc123)
        assertIs<ReadTimerOperation>(operation)
    }

    @Test
    fun createConvertBase10() {
        val operation = OperationFactory.create(0xd123)
        assertIs<ConvertToBase10Operation>(operation)
    }

    @Test
    fun createConvertAscii() {
        val operation = OperationFactory.create(0xe123)
        assertIs<ConvertByteToAsciiOperation>(operation)
    }

    @Test
    fun createDraw() {
        val operation = OperationFactory.create(0xf123)
        assertIs<DrawOperation>(operation)
    }

    @Test
    fun invalidOpcode() {
        assertFailsWith<IllegalArgumentException> {
            OperationFactory.create(999999)
        }
    }
}