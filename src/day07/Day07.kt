package day07

import println
import readInput
import java.math.BigInteger

fun main() {

    fun splitLine(input: List<String>): Map<BigInteger, String> {
        val map = mutableMapOf<BigInteger, String>()
        for (line in input) {
            val lineParts = line.split(": ")
            val result = lineParts[0].toBigIntegerOrNull()
                ?: throw IllegalArgumentException("Invalid key: ${lineParts[0]}")
            val numbers = lineParts[1]
            map[result] = numbers
        }
        return map
    }

    fun replaceSpacesWithOperators(input: String, operators: List<String>): String {
        val parts = input.split(" ")
        if (operators.size != parts.size - 1) {
            throw IllegalArgumentException("The operators list must have exactly ${parts.size - 1} elements.")
        }

        return parts.zip(operators) { part, operator ->
            "$part $operator"
        }.joinToString(" ") + " " + parts.last()
    }

    fun evaluateExpression(expression: String): BigInteger {
        val tokens = expression.split(" ")
        if (tokens.isEmpty()) throw IllegalArgumentException("Expression cannot be empty")

        var result = tokens[0].toBigIntegerOrNull()
            ?: throw IllegalArgumentException("Invalid number: ${tokens[0]}")

        var i = 1
        while (i < tokens.size) {
            val operator = tokens[i]
            val nextNumber = tokens.getOrNull(i + 1)?.toBigIntegerOrNull()
                ?: throw IllegalArgumentException("Invalid number: ${tokens.getOrNull(i + 1)}")

            result = when (operator) {
                "+" -> result + nextNumber
                "*" -> result * nextNumber
                else -> throw IllegalArgumentException("Invalid operator: $operator")
            }
            i += 2
        }
        return result
    }

    fun generateCombinations(operators: List<String>, length: Int): List<List<String>> {
        if (length == 1) return operators.map { listOf(it) }
        val subCombinations = generateCombinations(operators, length - 1)
        return operators.flatMap { operator ->
            subCombinations.map { combination -> listOf(operator) + combination }
        }
    }

    fun generateOperatorCombinations(operators: List<String>, occurrences: Int): List<List<String>> {
        if (occurrences <= 0) return emptyList()
        return generateCombinations(operators, occurrences)
    }

    fun part1(input: List<String>): BigInteger {
        val operators = listOf("*", "+")
        var sum: BigInteger = BigInteger.ZERO
        val resMap = splitLine(input)

        for ((key, value) in resMap) {
            val numberOfNumbers = value.split(" ").count()
            val numberOfOperators = numberOfNumbers - 1
            val combinations = generateOperatorCombinations(operators, numberOfOperators)
            for (combination in combinations) {
                val expression = replaceSpacesWithOperators(value, combination)
                val evaluatedResult = evaluateExpression(expression)
                if (evaluatedResult == key) {
                    sum += key
                    break
                }
            }
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("day07/Day07")
    part1(input).println()
//    part2(input).println()
}
