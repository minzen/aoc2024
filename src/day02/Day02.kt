fun main() {

    fun calcDifference(previousVal: Int, currentVal: Int) {

    }
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
        println (input)
        var safeReportsCount = 0
        for (line in input) {
            if (isASafeReport(line)) {
                safeReportsCount++
            }
        }
        return safeReportsCount
    }

    fun part2(input: List<String>): Int {
        return input.size
    }


    val input = readInput("day02/Day02")
    part1(input).println()
    part2(input).println()
}
