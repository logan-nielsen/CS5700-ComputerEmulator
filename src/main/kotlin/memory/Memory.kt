package org.example.memory

abstract class Memory(size: Int) {
    protected val data = IntArray(size)

    fun read(address: Int): Int {
        return data[address]
    }

    fun load(newData: IntArray) {
        newData.copyInto(data)
    }

    abstract fun write(address: Int, value: Int)
}