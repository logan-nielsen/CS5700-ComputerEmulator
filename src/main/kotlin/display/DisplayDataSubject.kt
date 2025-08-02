package org.example.display

interface DisplayDataSubject {
    fun registerObserver(observer: DisplayDataObserver)
    fun removeObserver(observer: DisplayDataObserver)
    fun notifyObservers()
}