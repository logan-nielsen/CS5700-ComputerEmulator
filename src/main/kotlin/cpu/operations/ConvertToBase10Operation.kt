package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.cpu.parseRegister
import org.example.memory.ComputerMemory

class ConvertToBase10Operation: Operation {
    override fun execute(instructionData: Int) {
        val register = parseRegister(instructionData, 1)
        val register1Value = CPU.getRegister(register)
        val convertedValue = register1Value.toString(10)

        for ((index, digit) in convertedValue.withIndex()) {
            val nextAddress = CPU.address + index
            val memory = ComputerMemory.getMemory(CPU.memoryType)
            memory.write(nextAddress, digit.digitToInt())
        }

        CPU.incrementProgramCounter()
    }
}