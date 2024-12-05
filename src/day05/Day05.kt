

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
                    //println(entry)
                    entryList.add(entry.toInt())
                }
                pagesList.add(entryList)
            }
        }
    }

    fun findMiddleItemInList(values: List<Int>): Int {
        return values[(values.size/2)];
    }

    fun containsInvalidEntry(valuesToTheLeft: List<Int>, ruleValues: List<Int>): Boolean {
        for (value in valuesToTheLeft) {
            if (ruleValues.contains(value)) {
                return true
            }
        }
        return false
    }

    // The order of the pages is defined by the rules
    // The map key indicate the number, and the values denote
    // the numbers that should be placed after the given number
    // Returns the sum of the middle page numbers
    fun updatesInCorrectOrder(): Int {
        var sum = 0
        // list of all the list of pages
        for (pages in pagesList) {
            // Go through a single list of pages
            var pagesAtLeft = mutableListOf<Int>()
            var invalidLine = false
            for (i in pages.indices) {
                val currentPageToCheck = pages[i]
                //println(pages[i])
                // Get the following pages for the current page
                val pagesShouldFollowCurrentPage = rulesMap[currentPageToCheck]
                if (pagesShouldFollowCurrentPage != null) {
                    if (containsInvalidEntry(pagesAtLeft, pagesShouldFollowCurrentPage)) {
                        invalidLine = true
                        break
                    }
                }
                pagesAtLeft.add(currentPageToCheck)
            }
            if (!invalidLine) {
                val middleItem = findMiddleItemInList(pages)
                sum += middleItem
            }
        }
        return sum
    }

    fun part1(input: List<String>): Int {
        readRulesAndInput(input)
        val sum = updatesInCorrectOrder()
        return sum
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val input = readInput("day05/Day05")
    part1(input).println()
    part2(input).println()
}
