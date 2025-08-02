package org.example.display.console

import org.example.display.DisplayDataObserver

class ConsoleDisplayViewModel: ConsoleDisplayViewModelSubject, DisplayDataObserver {
    private val observers = mutableListOf<ConsoleDisplayViewModelObserver>()
    private var data: String = ""

    override fun registerObserver(observer: ConsoleDisplayViewModelObserver) {
        observers += observer
    }

    override fun removeObserver(observer: ConsoleDisplayViewModelObserver) {
        observers -= observer
    }

    override fun notifyObservers() {
        for (observer in observers) {
            observer.update(data)
        }
    }

    override fun update(newData: List<List<Char>>) {
        data = newData.joinToString(separator = "\n") { it.joinToString(separator = "") }
        notifyObservers()
    }
}