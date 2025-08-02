package org.example.memory

object ComputerMemory {
    private val memory = mapOf<String, Memory>(
        // TODO: Fix the size
        "RAM" to RAM(1024),
        "ROM" to ROM(1024),
    )

    public fun getMemory(type: MemoryType): Memory {
        return memory[type.name]!!
    }
}