package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.memory.MemoryType

class SwitchMemoryOperation: Operation {
    override fun execute(instructionData: Int) {
        if (CPU.memoryType == MemoryType.RAM) {
            CPU.memoryType = MemoryType.ROM
        } else {
            CPU.memoryType = MemoryType.RAM
        }

        CPU.incrementProgramCounter()
    }
}