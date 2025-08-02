package org.example.display.console

interface ConsoleDisplayViewModelSubject {
    fun registerObserver(observer: ConsoleDisplayViewModelObserver)
    fun removeObserver(observer: ConsoleDisplayViewModelObserver)
    fun notifyObservers()
}