package org.example.cpu.operations

import org.example.cpu.CPU

class StoreOperation: Operation {
    override fun execute(register1: Int, register2: Int?, register3: Int?) {
        requireNotNull(register2)
        CPU.setRegister(register2, register1)

        CPU.programCounter += 2
    }

}