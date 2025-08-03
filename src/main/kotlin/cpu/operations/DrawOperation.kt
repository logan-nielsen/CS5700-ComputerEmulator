package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.cpu.parseRegister
import org.example.display.DisplayData

class DrawOperation: Operation {
    override fun execute(instructionData: Int) {
        val register1 = parseRegister(instructionData, 1)
        val row = parseRegister(instructionData, 2)
        val col = parseRegister(instructionData, 3)

        DisplayData.drawCharacter(
            character = CPU.getRegister(register1).toChar(),
            row = row,
            col = col,
        )

        CPU.incrementProgramCounter()
    }
}