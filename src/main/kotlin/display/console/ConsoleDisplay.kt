package org.example.display.console

class ConsoleDisplay: ConsoleDisplayViewModelObserver {
    override fun update(newData: String) {
        print("\u001b[H\u001b[2J") // Clears the screen and moves cursor to top-left
        println(newData)
    }
}