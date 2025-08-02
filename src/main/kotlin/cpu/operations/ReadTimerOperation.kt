package org.example.cpu.operations

import org.example.cpu.CPU

class ReadTimerOperation: Operation {
    override fun execute(register1: Int, register2: Int?, register3: Int?) {
        CPU.setRegister(register1, CPU.timer)
        CPU.programCounter += 2
    }
}