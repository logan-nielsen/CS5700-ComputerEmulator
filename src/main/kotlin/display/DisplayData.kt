package org.example.display

object DisplayData: DisplayDataSubject {
    const val rows = 0x7f
    const val cols = 0x7f

    private val data = Array(rows) { CharArray(cols) }

    private val observers = mutableListOf<DisplayDataObserver>()

    override fun registerObserver(observer: DisplayDataObserver) {
        observers += observer
    }

    override fun removeObserver(observer: DisplayDataObserver) {
        observers -= observer
    }

    override fun notifyObservers() {
        for (observer in observers) {
            val dataClone = List(data.size) { i ->
                data[i].toList() // clone each inner array
            }
            observer.update(dataClone)
        }
    }

    fun drawCharacter(character: Char, row: Int, col: Int) {
        require(row > 0x00 && row <= 0x7f) { "Row must be between 0x00 and 0x7F" }
        require(col > 0x00 && col <= 0x7f) { "Col must be between 0x00 and 0x7F" }

        data[row][col] = character

        notifyObservers()
    }
}