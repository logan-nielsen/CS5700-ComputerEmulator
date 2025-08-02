package org.example.cpu.operations

interface Operation {
    fun execute(register1: Int, register2: Int, register3: Int)
}