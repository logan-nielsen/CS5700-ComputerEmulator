package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.cpu.parseRegister

class WriteOperation: Operation {
    override fun execute(instructionData: Int) {
        val register = parseRegister(instructionData, 1)

        val readValue = CPU.getRegister(register)
        CPU.setRegister(CPU.address, readValue)

        CPU.incrementProgramCounter()
    }
}