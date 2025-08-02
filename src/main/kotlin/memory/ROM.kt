package org.example.memory

class ROM(size: Int): Memory(size) {
    override fun write(address: Int, value: Int) {
        throw Exception("Cannot write to ROM")
    }
}