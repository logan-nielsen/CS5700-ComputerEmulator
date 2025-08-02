package org.example.cpu.operations

import org.example.cpu.CPU

class ReadOperation: Operation {
    override fun execute(register1: Int, register2: Int?, register3: Int?) {
        val readValue = CPU.getRegister(CPU.address)
        CPU.setRegister(register1, readValue)

        CPU.programCounter += 2
    }
}