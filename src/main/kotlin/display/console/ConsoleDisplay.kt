package org.example.display.console

class ConsoleDisplay: ConsoleDisplayViewModelObserver {
    override fun update(newData: String) {
        println(newData)
    }
}