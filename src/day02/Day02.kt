fun main() {

    // A safe report is either gradually increasing or gradually decreasing
    // * The levels are all increasing or all decreasing
    // * Any two adjacent levels differ by at least one and at most three
    fun isASafeReport(line: String): Boolean {
        val lineAsValues = line.split(" ")
        val modifiedValues = lineAsValues.drop(1)
        var first = lineAsValues[0].toInt()
        var second = lineAsValues[1].toInt()
        var previous = first

        var increasing: Boolean
        if (second > first) {
            increasing = true;
        } else {
            increasing = false;
        }

        for (i in modifiedValues.indices) {
            val value = modifiedValues[i].toInt()
            if (increasing) {
                if (value > previous) {
                    if (value - previous > 3) {
                        return false
                    }
                } else {
                    return false
                }
            } else {
                if (value < previous) {
                    if (previous - value > 3) {
                        return false
                    }
                } else {
                    return false
                }
            }
            previous = value
        }
        return true
    }

    fun part1(input: List<String>): Int {
        var safeReportsCount = 0
        for (line in input) {
            if (isASafeReport(line)) {
                safeReportsCount++
            }
        }
        return safeReportsCount
    }

    fun createModifiedList(dropIndex: Int, lineAsValues: List<String>): MutableList<String> {
        val modifiedList = mutableListOf<String>()
        for (i in lineAsValues.indices) {
            if (i != dropIndex) {
                modifiedList.add(lineAsValues[i])
            }
        }
        return modifiedList
    }

    fun part2(input: List<String>): Int {
        var safeReportsCount = 0
        for (line in input) {
            if (isASafeReport(line)) {
                safeReportsCount++
            }
            // Otherwise check whether one of the alternative lines (with one item removed also
            // would be a safe report)
            else {
                val lineAsValues = line.split(" ")
                var indexToDrop: Int
                for (i in lineAsValues.indices) {
                    indexToDrop = i
                    var modifiedLine = createModifiedList(indexToDrop, lineAsValues)
                    if (isASafeReport(modifiedLine.joinToString(separator = " "))) {
                        safeReportsCount++
                        break
                    }
                }
            }
        }
        return safeReportsCount
    }


    val input = readInput("day02/Day02")
    part1(input).println()
    part2(input).println()
}
