package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.cpu.parseRegister

class ConvertByteToAsciiOperation: Operation {
    override fun execute(instructionData: Int) {
        val register1 = parseRegister(instructionData, 1)
        val register2 = parseRegister(instructionData, 2)

        val register1Value = CPU.getRegister(register1)
        require(register1Value <= 0xf) { "Register 1's value 0x$register1Value must not be greater than 0xF" }

        val asciiValue = if (register1Value < 10) {
            ('0'.code + register1Value).toChar()
        } else {
            ('a'.code + (register1Value - 10)).toChar()
        }

        CPU.setRegister(register2, asciiValue.code)

        CPU.incrementProgramCounter()
    }
}