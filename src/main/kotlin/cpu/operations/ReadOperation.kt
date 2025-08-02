package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.cpu.parseRegister

class ReadOperation: Operation {
    override fun execute(instructionData: Int) {
        val register = parseRegister(instructionData, 1)

        val readValue = CPU.getRegister(CPU.address)
        CPU.setRegister(register, readValue)

        CPU.incrementProgramCounter()
    }
}