package org.example.cpu

import org.example.cpu.operations.OperationFactory
import org.example.memory.ComputerMemory
import org.example.memory.MemoryType
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

object CPU {
    val executor: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()

    var paused = true

    init {
        val cpuRunnable = Runnable(::executeNextInstruction)

        executor.scheduleAtFixedRate(
            cpuRunnable,
            0,
            2L, // repeat frequency - every 2 ms
            TimeUnit.MILLISECONDS
        )


        val timerRunnable = Runnable(::decrementTimer)

        executor.scheduleAtFixedRate(
            timerRunnable,
            0,
            16L, // repeat frequency - every 16 ms
            TimeUnit.MILLISECONDS
        )
    }

    var programCounter: Int = 0x000
        set(value) {
            require(value % 2 == 0) { "Program counter value must be even" }
            field = value
        }

    var timer: Int = 0
        set(value) {
            require(value >= 0) { "Timer value cannot be negative" }
            field = value
        }

    var address: Int = 0x000
        set(value) {
            require(value >= 0) { "Address value cannot be negative" }
            field = value
        }

    var memoryType: MemoryType = MemoryType.RAM

    private val registers = IntArray(8)

    fun executeNextInstruction() {
        try {
            if (!paused) {
                val rom = ComputerMemory.getMemory(MemoryType.ROM)
                val instructionPart1 = rom.read(programCounter)
                val instructionPart2 = rom.read(programCounter + 1)
                val instruction = ((instructionPart1 and 0xFF) shl 8) or (instructionPart2 and 0xFF)

                val operation = OperationFactory.create(instruction)
                operation.execute(instruction and 0x0FFF)
            }
        } catch (e: Exception) {
            println("Error executing instruction at ${programCounter/2}:")
            println(e.stackTraceToString())
            stop()
        }
    }

    fun loadROM(data: IntArray) {
        ComputerMemory.getMemory(MemoryType.ROM).load(data)
    }

    fun getRegister(register: Int): Int {
        return registers[register]
    }

    fun setRegister(register: Int, value: Int) {
        registers[register] = value
    }

    fun decrementTimer() {
        if (timer > 0) {
            timer--
        }
    }

    fun pause() {
        paused = true
    }

    fun start() {
        paused = false
    }

    fun stop() {
        executor.shutdown() // turns off the executor allowing the program to terminate when the end is reached
    }

    fun incrementProgramCounter(amount: Int = 1) {
        programCounter += amount * 2
    }
}
