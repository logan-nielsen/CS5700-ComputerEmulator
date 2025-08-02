package org.example.cpu

import org.example.memory.ComputerMemory
import org.example.memory.MemoryType
import org.example.memory.RAM

object CPU {
    var programCounter: Int = 0x000
        private set;

    var timer: Int = 0
        set(value) {
            require(field >= 0) { "Timer value cannot be negative" }
            field = value
        }

    var address: Int = 0x000
        private set;

    var memoryType: MemoryType = MemoryType.RAM

    val registers = IntArray(8)
        private set;

    fun executeNextInstruction() {

    }

    fun loadROM(data: IntArray) {
        val memory = ComputerMemory.getMemory(MemoryType.ROM).load(data)
    }

    fun setRegister(register: Int, value: Int) {
        registers[register] = value
    }
}
