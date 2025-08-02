package org.example.display.userinput

object ConsoleUserInput: UserInput {
    override fun get(): String {
        return readln()
    }
}