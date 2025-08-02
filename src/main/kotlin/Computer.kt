package org.example

import org.example.cpu.CPU
import org.example.display.DisplayData
import org.example.display.console.ConsoleDisplay
import org.example.display.console.ConsoleDisplayViewModel
import org.example.display.userinput.ConsoleUserInput
import java.io.File

class Computer {
    fun runProgram() {
        println("Enter the path to the ROM file:")
//        val romPath = ConsoleUserInput.get()
        val romPath = "roms/addition.out"

        val romBytes = File(romPath).readBytes()
        val romData = romBytes.map { it.toInt() }.toIntArray()
        CPU.loadROM(romData)

        val consoleDisplayViewModel = ConsoleDisplayViewModel()
        DisplayData.registerObserver(consoleDisplayViewModel)

        val consoleDisplay = ConsoleDisplay()
        consoleDisplayViewModel.registerObserver(consoleDisplay)

        CPU.start()
    }
}