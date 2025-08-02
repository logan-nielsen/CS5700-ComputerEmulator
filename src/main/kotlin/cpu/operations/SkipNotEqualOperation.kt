package org.example.cpu.operations

import org.example.cpu.CPU

class SkipNotEqualOperation: Operation {
    override fun execute(register1: Int, register2: Int?, register3: Int?) {
        requireNotNull(register2)

        val register1Value = CPU.getRegister(register1)
        val register2Value = CPU.getRegister(register2)

        if (register1Value != register2Value) {
            CPU.programCounter += 4
        } else {
            CPU.programCounter += 2
        }
    }
}