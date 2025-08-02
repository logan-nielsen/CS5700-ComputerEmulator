package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.cpu.parseByte

class SetTimerOperation: Operation {
    override fun execute(instructionData: Int) {
        CPU.timer = parseByte(instructionData, 1)
        CPU.incrementProgramCounter()
    }
}