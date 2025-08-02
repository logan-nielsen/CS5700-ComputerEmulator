package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.memory.ComputerMemory

class ConvertToBase10Operation: Operation {
    override fun execute(register1: Int, register2: Int?, register3: Int?) {
        val register1Value = CPU.getRegister(register1)
        val convertedValue = register1Value.toString(10)

        for ((index, digit) in convertedValue.withIndex()) {
            val nextAddress = CPU.address + index
            val memory = ComputerMemory.getMemory(CPU.memoryType)
            memory.write(nextAddress, digit.code)
        }

        CPU.programCounter += 2
    }
}