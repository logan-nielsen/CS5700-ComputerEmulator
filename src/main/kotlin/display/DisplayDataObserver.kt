package org.example.display

interface DisplayDataObserver {
    fun update(newData: List<List<Char>>)
}