package org.example.cpu.operations

object OperationFactory {
    fun create(instruction: Int): Operation {
        if (instruction == 0x000) return StopOperation()

        val opcode = instruction shr 12
        return when (opcode) {
            0x0 -> StoreOperation()
            0x1 -> AddOperation()
            0x2 -> SubOperation()
            0x3 -> ReadOperation()
            0x4 -> WriteOperation()
            0x5 -> JumpOperation()
            0x6 -> ReadKeyboardOperation()
            0x7 -> SwitchMemoryOperation()
            0x8 -> SkipEqualOperation()
            0x9 -> SkipNotEqualOperation()
            0xa -> SetAddressOperation()
            0xb -> SetTimerOperation()
            0xc -> ReadTimerOperation()
            0xd -> ConvertToBase10Operation()
            0xe -> ConvertByteToAsciiOperation()
            0xf -> DrawOperation()
            else -> throw IllegalArgumentException("Invalid opcode: $opcode")
        }
    }
}