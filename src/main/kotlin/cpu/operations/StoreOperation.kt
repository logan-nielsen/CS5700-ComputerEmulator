package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.cpu.parseByte
import org.example.cpu.parseRegister

class StoreOperation: Operation {
    override fun execute(instructionData: Int) {
        val register = parseRegister(instructionData, 1)
        val byte = parseByte(instructionData, 2)

        CPU.setRegister(register, byte)

        CPU.incrementProgramCounter()
    }

}