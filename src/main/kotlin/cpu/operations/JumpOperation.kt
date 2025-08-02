package org.example.cpu.operations

import org.example.cpu.CPU

class JumpOperation: Operation {
    override fun execute(register1: Int, register2: Int?, register3: Int?) {
        val register1Value = CPU.getRegister(register1)
        require(register1Value % 2 == 0) { "Program counter cannot be set to an odd value" }
        CPU.programCounter = register1Value
    }
}