package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.cpu.parseRegister
import org.example.display.DisplayData

class DrawOperation: Operation {
    override fun execute(instructionData: Int) {
        val register1 = parseRegister(instructionData, 1)
        val register2 = parseRegister(instructionData, 2)
        val register3 = parseRegister(instructionData, 3)

        DisplayData.drawCharacter(
            character = register1.toChar(),
            row = register2,
            col = register3
        )

        CPU.incrementProgramCounter()
    }
}