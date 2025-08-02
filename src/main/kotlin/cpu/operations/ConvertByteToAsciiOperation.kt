package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.cpu.parseRegister

class ConvertByteToAsciiOperation: Operation {
    override fun execute(instructionData: Int) {
        val register1 = parseRegister(instructionData, 1)
        val register2 = parseRegister(instructionData, 2)

        val register1Value = CPU.getRegister(register1).toChar()
        require(register1Value <= 'F') { "Register 1's value 0x$register1Value must not be greater than 0xF" }

        CPU.setRegister(register2, register1Value.code)

        CPU.incrementProgramCounter()
    }
}