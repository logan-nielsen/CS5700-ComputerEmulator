package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.cpu.parseRegister
import org.example.display.userinput.ConsoleUserInput

class ReadKeyboardOperation: Operation {
    override fun execute(instructionData: Int) {
        CPU.pause()
        val input = ConsoleUserInput.get()

        val parsedInput = if (input.isEmpty()) {
            0
        } else {
            val len = minOf(2, input.length)
            input.substring(0, len).toInt(16)
        }

        val register = parseRegister(instructionData, 1)
        CPU.setRegister(register, parsedInput)
        CPU.incrementProgramCounter()
        CPU.start()
    }
}