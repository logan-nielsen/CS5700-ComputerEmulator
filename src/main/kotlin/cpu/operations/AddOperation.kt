package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.cpu.parseRegister

class AddOperation: Operation {
    override fun execute(instructionData: Int) {
        val register1 = parseRegister(instructionData, 1)
        val register2 = parseRegister(instructionData, 2)
        val register3 = parseRegister(instructionData, 3)

        val result = CPU.getRegister(register1) + CPU.getRegister(register2)
        CPU.setRegister(register3, result)

        CPU.incrementProgramCounter()
    }
}