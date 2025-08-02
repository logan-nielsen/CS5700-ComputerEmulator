package org.example.memory

class RAM(size: Int): Memory(size) {
    override fun write(address: Int, value: Int) {
        this.data[address] = value
    }
}