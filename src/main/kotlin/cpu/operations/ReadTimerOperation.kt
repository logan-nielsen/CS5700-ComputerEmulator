package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.cpu.parseRegister

class ReadTimerOperation: Operation {
    override fun execute(instructionData: Int) {
        val register = parseRegister(instructionData, 1)
        CPU.setRegister(register, CPU.timer)
        CPU.incrementProgramCounter()
    }
}