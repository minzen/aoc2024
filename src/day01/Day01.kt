package day01

import println
import readInput

fun main() {

    fun readInputToList(input: List<String>, idx: Int): List<Int> {
        val numbers = mutableListOf<Int>()
        input.forEach { line ->
            val splitted = line.split("   ")
            numbers.add(splitted[idx].toInt())
        }
        return numbers.sorted()
    }

    fun calculateDifference(val1: Int, val2: Int): Int {
        if (val1 < val2) {
            return val2 - val1
        }
        return val1 - val2
    }

    fun calculateDifferences(values1: List<Int>, values2: List<Int>): List<Int> {
        val differences = mutableListOf<Int>()
        for (i in values1.indices) {
            val diff = calculateDifference(values1[i], values2[i])
            differences.add(diff)
        }
        return differences
    }

    fun part1Sum(input: List<Int>): Int {
        var sum = 0
        for (i in input) {
            sum += i
        }
        return sum
    }

    fun part1(input: List<String>): Int {
        val values1 = readInputToList(input, 0)
        val values2 = readInputToList(input, 1)
        val differences = calculateDifferences(values1, values2)
        val sum = part1Sum(differences)
        return sum
    }

    fun calculateNumberOfOccurrences(valueToSearch: Int, valueList: List<Int>): Int {
        var count = 0
        for (value in valueList) {
            if (value == valueToSearch) {
                count++
            }
        }
        return count
    }

    fun part2(input: List<String>): Int {
        val values1 = readInputToList(input, 0)
        val values2 = readInputToList(input, 1)
        var sum = 0
        for (value in values1) {
            var occurrencesForValue = calculateNumberOfOccurrences(value, values2)
            sum += occurrencesForValue * value
        }
        return sum
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("day01/Day01")
    part1(input).println()
    part2(input).println()
}
