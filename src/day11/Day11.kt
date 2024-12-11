package day11

import println
import readInput

fun main() {

    fun readInputToListOfIntegers(input: List<String>): List<Int> {
        var list = mutableListOf<Int>()

        for (i in input.indices) {
            val row = input[i]
            val splittedRow = row.split(" ")
            for (item in splittedRow) {
                list.add(item.toInt())
            }
        }
        return list
    }

    // Rules
    // If the stone is engraved with the number 0, it is replaced by a stone engraved with the number 1
    // If the number is engraved with a number that has an even number of digits, it is replaced by two stones.
    // In that case the left half of the digits are engraved on the left stone , and the right half of the digits
    // are engraved on the new right stone. (The new numbers don't keep extra leading zeroes
    // If none of the other rules apply, the stone is replaced by a new stone; the old stone's number
    // multiplied by 2024 is engraved on the new stone.
    fun applyRuleToNumber(number: Int): List<Int> {
        var list = mutableListOf<Int>()
        if (number == 0) {
            list.add(1)
        }
        else if (number.toString().length % 2 == 0) {

        }
    }

    fun part1(input: List<String>): Int {
        val list = readInputToListOfIntegers(input)
        return list.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("day11/Day11")
    part1(input).println()
    part2(input).println()
}
