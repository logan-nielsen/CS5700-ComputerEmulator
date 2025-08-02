package org.example.cpu.operations

import org.example.cpu.CPU
import org.example.display.DisplayData

class DrawOperation: Operation {
    override fun execute(register1: Int, register2: Int?, register3: Int?) {
        requireNotNull(register2)
        requireNotNull(register3)

        DisplayData.drawCharacter(
            character = register1.toChar(),
            row = register2,
            col = register3
        )

        CPU.programCounter += 2
    }
}