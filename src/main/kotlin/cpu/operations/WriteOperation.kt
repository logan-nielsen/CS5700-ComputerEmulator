package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.cpu.parseRegister
import org.example.memory.ComputerMemory

class WriteOperation: Operation {
    override fun execute(instructionData: Int) {
        val register = parseRegister(instructionData, 1)

        val readValue = CPU.getRegister(register)
        ComputerMemory.getMemory(CPU.memoryType).write(CPU.address, readValue)

        CPU.incrementProgramCounter()
    }
}