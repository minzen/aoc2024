package day03

import println
import readInput

fun main() {

    val mulRegexPattern = """mul\(\d+,\d+\)"""

    fun stripMulStr(input: String): Pair<Int, Int> {
        val pairStr = input.substring(4, input.length - 1).split(",")
        return Pair(pairStr[0].toInt(), pairStr[1].toInt())
    }

    fun readInputToListOfPairs(input: List<String>): MutableList<Pair<Int, Int>> {
        var pairs: MutableList<Pair<Int, Int>> = mutableListOf()
        val regex = mulRegexPattern.toRegex()
        for (line in input) {
            val matchResults = regex.findAll(line)
            for (matchResult in matchResults)
                pairs.add(stripMulStr(matchResult.value))
            }
        return pairs
    }


    fun part1(input: List<String>): Int {
        var pairs = readInputToListOfPairs(input)
        var sum = 0
        for (pair in pairs) {
            sum += pair.first * pair.second
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("day03/Day03")
    part1(input).println()
    part2(input).println()
}
