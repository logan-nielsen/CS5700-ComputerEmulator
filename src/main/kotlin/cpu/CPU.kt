package org.example.cpu

import org.example.cpu.operations.OperationFactory
import org.example.memory.ComputerMemory
import org.example.memory.MemoryType
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

object CPU {
    val executor: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
    val cpuFuture: ScheduledFuture<*>
    val timerFuture: ScheduledFuture<*>

    var paused = true

    init {
        val cpuRunnable = Runnable(::executeNextInstruction)

        cpuFuture = executor.scheduleAtFixedRate(
            cpuRunnable,
            0,
            2L, // repeat frequency - every 2 ms
            TimeUnit.MILLISECONDS
        )


        val timerRunnable = Runnable(::decrementTimer)

        timerFuture = executor.scheduleAtFixedRate(
            timerRunnable,
            0,
            16L, // repeat frequency - every 16 ms
            TimeUnit.MILLISECONDS
        )
    }

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
        if (!paused) {
            val rom = ComputerMemory.getMemory(MemoryType.ROM)
            val instruction = rom.read(programCounter)
            val opcode = instruction and 0xF000
            val operation = OperationFactory.create(opcode)
            operation.execute(instruction and 0x0FFF)
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
