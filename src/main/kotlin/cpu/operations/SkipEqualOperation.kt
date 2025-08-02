package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.cpu.parseRegister

class SkipEqualOperation: Operation {
    override fun execute(instructionData: Int) {
        val register1 = parseRegister(instructionData, 1)
        val register2 = parseRegister(instructionData, 2)

        val register1Value = CPU.getRegister(register1)
        val register2Value = CPU.getRegister(register2)

        if (register1Value == register2Value) {
            CPU.incrementProgramCounter(2)
        } else {
            CPU.incrementProgramCounter()
        }
    }
}