package org.example.cpu.operations

import org.example.cpu.CPU

class SetAddressOperation: Operation {
    override fun execute(register1: Int, register2: Int?, register3: Int?) {
        CPU.address = register1
        CPU.programCounter += 2
    }
}