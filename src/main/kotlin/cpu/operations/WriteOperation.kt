package org.example.cpu.operations

import org.example.cpu.CPU

class WriteOperation: Operation {
    override fun execute(register1: Int, register2: Int?, register3: Int?) {
        val readValue = CPU.getRegister(register1)
        CPU.setRegister(CPU.address, readValue)

        CPU.programCounter += 2
    }
}