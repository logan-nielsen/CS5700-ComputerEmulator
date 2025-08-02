package org.example.memory

abstract class Memory(size: Int) {
    protected val data = IntArray(size)

    fun read(address: Int): Int {
        return data[address]
    }

    fun load(data: IntArray) {
        this.data.copyInto(data)
    }

    abstract fun write(address: Int, value: Int)
}