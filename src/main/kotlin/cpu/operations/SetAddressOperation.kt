package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.cpu.parseAddress

class SetAddressOperation: Operation {
    override fun execute(instructionData: Int) {
        CPU.address = parseAddress(instructionData)
        CPU.incrementProgramCounter()
    }
}