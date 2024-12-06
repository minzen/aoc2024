package day06

import readInput
import println

enum class Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT
}

fun main() {

    val guardCharacter = listOf('^', '>', '<', 'v')
    var initialPosition: Pair<Int, Int> = Pair(-1, -1)
    var visitedCells: MutableSet<Pair<Int, Int>> = mutableSetOf()
    var boundariesOfArray: MutableList<Pair<Int, Int>> = mutableListOf()

    // Traversal of the array:
    // * Have a bookkeeping of visited cells
    // * Continue to the current direction, until an obstacle or the boundary of the array is reached.
    // * In case of an obstacle turn to the follo

    fun exceedingBoundaries(direction: Direction, currentPos: Pair<Int, Int>): Boolean {
        if (direction == Direction.UP) {
            var nextPos: Pair<Int, Int> = Pair(currentPos.first, currentPos.second)

        }
        return false
    }

    fun setBoundariesOfArray(array: List<List<Char>>) {
        val topLeft = Pair(0, 0)
        boundariesOfArray.add(topLeft)
        var topRight = Pair(array[0].size - 1, 0)
        boundariesOfArray.add(topRight)
        var bottomLeft = Pair(0, array.size - 1)
        boundariesOfArray.add(bottomLeft)
        var bottomRight = Pair(array[0].size - 1, array.size - 1)
        boundariesOfArray.add(bottomRight)
        println("topLeft: $topLeft")
        println("topRight: $topRight")
        println("bottomRight: $bottomRight")
        println("bottomLeft: $bottomLeft")
    }

    // Reads the input to a twodimensional char array
    fun readInputToArray(input: List<String>): List<List<Char>> {
        val listOfRows = mutableListOf<List<Char>>()
        for (row in input.indices) {
            val listOfColumns = mutableListOf<Char>()
            val currentRow = input[row]
            for (col in currentRow.indices) {
                // Find the starting coordinate and direction
                if (guardCharacter.contains(currentRow[col])) {
                    initialPosition = Pair(row, col)
                    visitedCells.add(Pair(row, col))
                }
                listOfColumns.add(currentRow[col])
            }
            listOfRows.add(listOfColumns)
        }

        return listOfRows
    }

    fun part1(input: List<String>): Int {
        val charArray = readInputToArray(input)
        println("Initial position: $initialPosition")
        setBoundariesOfArray(charArray)
        return charArray.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("day06/Day06")
    part1(input).println()
    part2(input).println()
}
