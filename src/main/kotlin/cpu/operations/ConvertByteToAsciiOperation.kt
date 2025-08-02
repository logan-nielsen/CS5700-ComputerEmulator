package org.example.cpu.operations

import org.example.cpu.CPU

class ConvertByteToAsciiOperation: Operation {
    override fun execute(register1: Int, register2: Int?, register3: Int?) {
        requireNotNull(register2)

        val register1Value = CPU.getRegister(register1)
        require(register1Value >= 0 && register1Value <= 0xf) { "Register 1 must be between 1 and 0xF" }

        val asciiVal = if (register1Value < 10) {
            ('0'.code + register1Value).toChar()
        } else {
            ('a'.code + (register1Value - 10)).toChar()
        }

        CPU.setRegister(register2, asciiVal.code)

        CPU.programCounter += 2
    }
}