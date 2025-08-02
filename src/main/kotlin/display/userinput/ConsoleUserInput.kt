package org.example.display.userinput

object ConsoleUserInput: UserInput {
    override fun get(): String {
        println("Waiting for input:")
        return readln()
    }
}