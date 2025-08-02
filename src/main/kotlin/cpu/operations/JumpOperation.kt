package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.cpu.parseAddress

class JumpOperation: Operation {
    override fun execute(instructionData: Int) {
        val address = parseAddress(instructionData)
        require(address % 2 == 0) { "Program counter cannot be set to an odd value" }
        CPU.programCounter = address
    }
}