package org.example.cpu

fun parseRegister(instructionData: Int, position: Int): Int {
    require(position in 1..3) { "Position must be between 1 and 3" }

    val mask = 0xf shl 4 * (3 - position)
    val shift = (3 - position) * 4
    return (instructionData and mask) shr shift
}

fun parseByte(instructionData: Int, position: Int): Int {
    require(position in 1..2) { "Position must be between 1 and 2" }

    val mask = 0xff shl 4 * (2 - position)
    val shift = (2 - position) * 4
    return (instructionData and mask) shr shift
}

fun parseAddress(instructionData: Int) = instructionData and 0x0fff