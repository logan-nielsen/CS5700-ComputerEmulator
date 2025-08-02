package org.example.cpu.operations

import org.example.cpu.CPU

class StopOperation: Operation {
    override fun execute(instructionData: Int) {
        CPU.stop()
    }
}