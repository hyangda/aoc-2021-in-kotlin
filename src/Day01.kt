fun main() {
    fun part1(input: List<String>): Int {
        val depthList = input.map { it.toInt() }
        var numIncreasing = 0
        var previousDepth = depthList.first()

        for (currentDepth in depthList.drop(1)) {
            if (currentDepth > previousDepth) {
                numIncreasing = numIncreasing.inc()
            }
            previousDepth = currentDepth
        }
        return numIncreasing
    }

    fun part2(input: List<String>): Int {
        val depthList = input.map { it.toInt() }
        var numIncreasing = 0
        var previousWindow = depthList.take(3).sum()
        var currentWindow: Int

        for (depthIndex in depthList.indices.drop(1).dropLast(2)) {
            currentWindow = depthList.subList(depthIndex, depthIndex + 3).sum()
            if (currentWindow > previousWindow) {
                numIncreasing = numIncreasing.inc()
            }
            previousWindow = currentWindow
        }
        return numIncreasing
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
