package org.example.cpu.operations

import org.example.cpu.CPU

class AddOperation: Operation {
    override fun execute(register1: Int, register2: Int?, register3: Int?) {
        requireNotNull(register2)
        requireNotNull(register3)

        val result = CPU.getRegister(register1) + CPU.getRegister(register2)
        CPU.setRegister(register3, result)

        CPU.programCounter += 2
    }
}