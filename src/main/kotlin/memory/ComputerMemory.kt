package org.example.memory

object ComputerMemory {
    private val memory = mapOf(
        // 4 kb each
        "RAM" to RAM(4000),
        "ROM" to ROM(4000),
    )

    fun getMemory(type: MemoryType): Memory {
        return memory[type.name]!!
    }
}