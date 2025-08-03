package org.example.display

object DisplayData: DisplayDataSubject {
    const val ROWS = 0x8
    const val COLS = 0x8

    private val data = Array(ROWS) { CharArray(COLS) }

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
        require(row >= 0x00 && row <= ROWS) { "Row must be between 0x0 and 0xF" }
        require(col >= 0x00 && col <= COLS) { "Col must be between 0x0 and 0xF" }

        data[row][col] = character

        notifyObservers()
    }

    fun getCharacter(row: Int, col: Int): Char {
        require(row >= 0x00 && row <= ROWS) { "Row must be between 0x0 and 0xF" }
        require(col >= 0x00 && col <= COLS) { "Col must be between 0x0 and 0xF" }
        return data[row][col]
    }
}