package org.example.cpu

import org.example.memory.ComputerMemory
import org.example.memory.MemoryType

object CPU {
    var programCounter: Int = 0x000
        set(value) {
            require(field % 2 == 0) { "Program counter value must be even" }
            field = value
        }

    var timer: Int = 0
        set(value) {
            require(field >= 0) { "Timer value cannot be negative" }
            field = value
        }

    var address: Int = 0x000
        set(value) {
            require(field >= 0) { "Address value cannot be negative" }
            field = value
        }

    var memoryType: MemoryType = MemoryType.RAM

    private val registers = IntArray(8)

    fun executeNextInstruction() {

    }

    fun loadROM(data: IntArray) {
        val memory = ComputerMemory.getMemory(MemoryType.ROM).load(data)
    }

    fun getRegister(register: Int): Int {
        return registers[register]
    }

    fun setRegister(register: Int, value: Int) {
        registers[register] = value
    }
}
