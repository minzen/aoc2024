

fun main() {
    val rulesMap = mutableMapOf<Int, List<Int>>()
    val pagesList = mutableListOf<List<Int>>()

    fun readRulesAndInput(input: List<String>) {
        for (line in input) {
            // Sorting rules
            if (line.contains("|")) {
                val lineEntries = line.split("|")
                val key = lineEntries[0].toInt()
                val value = lineEntries[1].toInt()

                if (key !in rulesMap) {
                    val values = mutableListOf<Int>()
                    values.add(value)
                    rulesMap[key] = values
                } else {
                    val existingRules = rulesMap[key]
                    val newRules = mutableListOf<Int>()
                    newRules.addAll(existingRules!!)
                    newRules.add(value)
                    rulesMap[key] = newRules
                }
            }
            // actual updates
            else if (line.contains(",")) {
                val lineEntries = line.split(",")
                val entryList = mutableListOf<Int>()
                for (entry in lineEntries) {
                    println(entry)
                    entryList.add(entry.toInt())
                }
                pagesList.add(entryList)
            }
        }
    }

    // The order of the pages is defined by the rules
    // The map key indicate the number, and the values denote
    // the numbers that should be placed after the given number
    // Returns the sum of the middle page numbers
    fun updatesInCorrectOrder(): Int {
        for (i in pagesList.indices) {
            val pagesToCheck = pagesList[i]
            for (page in pagesToCheck) {

            }
        }
        return 0
    }

    fun part1(input: List<String>): Int {
        readRulesAndInput(input)
        updatesInCorrectOrder()
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("day05/Day05")
    part1(input).println()
    part2(input).println()
}
