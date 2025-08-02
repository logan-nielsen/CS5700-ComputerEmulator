package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.cpu.parseRegister
import org.example.memory.ComputerMemory

class ReadOperation: Operation {
    override fun execute(instructionData: Int) {
        val register = parseRegister(instructionData, 1)

        val memory = ComputerMemory.getMemory(CPU.memoryType)
        val readValue = memory.read(CPU.address)
        CPU.setRegister(register, readValue)

        CPU.incrementProgramCounter()
    }
}