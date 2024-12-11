package day11

import println
import readInput
import java.math.BigInteger

fun main() {

    fun readInputToListOfIntegers(input: List<String>): List<BigInteger> {
        return input.flatMap { row -> row.split(" ").map { it.toBigInteger() } }
    }

    // Rules
    // If the stone is engraved with the number 0, it is replaced by a stone engraved with the number 1
    // If the number is engraved with a number that has an even number of digits, it is replaced by two stones.
    // In that case the left half of the digits are engraved on the left stone , and the right half of the digits
    // are engraved on the new right stone. (The new numbers don't keep extra leading zeroes
    // If none of the other rules apply, the stone is replaced by a new stone; the old stone's number
    // multiplied by 2024 is engraved on the new stone.
    fun applyRuleToNumber(number: BigInteger): List<BigInteger> {
        var list = mutableListOf<BigInteger>()
        var numberAsString = number.toString()
        if (number == BigInteger.ZERO) {
            list.add(BigInteger.ONE)
        } else if (numberAsString.length % 2 == 0) {
            val leftPart = numberAsString.substring(0, numberAsString.length / 2)
            val rightPart = numberAsString.substring(numberAsString.length / 2)
            list.add(leftPart.toBigInteger())
            list.add(rightPart.toBigInteger())
        } else {
            list.add(number * BigInteger.valueOf(2024))
        }
        return list
    }

    fun execComputationRounds(numberList: List<BigInteger>, rounds: Int): List<BigInteger> {
        var currentList = numberList
        repeat(rounds) {
            currentList = currentList.flatMap { applyRuleToNumber(it) }
            println("current = $currentList")
        }
        return currentList
    }

    fun part1(input: List<String>): Int {
        val initialList = readInputToListOfIntegers(input)
        //println("initial list: $initialList")
        var resultList = execComputationRounds(initialList, 25)
        println("resultList: $resultList")
        return resultList.size
    }

    fun part2(input: List<String>): Int {
        val initialList = readInputToListOfIntegers(input)
        var resultList = execComputationRounds(initialList, 75)
        println("resultList: $resultList")
        return resultList.size
    }

    val input = readInput("day11/Day11")
    part1(input).println()
    part2(input).println()
}
