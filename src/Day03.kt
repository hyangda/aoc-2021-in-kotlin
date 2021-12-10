import kotlin.math.pow

fun main() {

    fun byteStringToInt(byteString: String): Int {
        var returnInt = 0.0
        for ((index, digit) in byteString.reversed().withIndex()) {
            // lol
            returnInt += 2.0.pow(index) * digit.toString().toInt()
        }
        return returnInt.toInt()
    }

    fun countOnesAndZeros(input: List<String>): Pair<IntArray, IntArray> {
        val numOnes = IntArray(input[0].length)
        val numZeros = IntArray(input[0].length)
        for (line in input) {
            for ((index, digit) in line.withIndex()) {
                if (digit.toString() == "1") {
                    numOnes[index] += 1
                }
                else {
                    numZeros[index] += 1
                }
            }
        }
        return Pair(numOnes, numZeros)
    }

    fun findGammaEpsilon(countOnesAndZeros: Pair<IntArray, IntArray>): Pair<String, String> {
        var gammaByteString = ""
        var epsilonByteString = ""
        for (index in countOnesAndZeros.first.indices) {
            if (countOnesAndZeros.first[index] > countOnesAndZeros.second[index]) {
                gammaByteString += "1"
                epsilonByteString += "0"
            }
            else {
                gammaByteString += "0"
                epsilonByteString += "1"
            }
        }
        return Pair(gammaByteString, epsilonByteString)
    }

    fun part1(input: List<String>): Int {
        val (gammaByteString, epsilonByteString) = findGammaEpsilon(countOnesAndZeros(input))
        return byteStringToInt(gammaByteString) * byteStringToInt(epsilonByteString)
    }

    fun getMostCommonBitInPosition(input: List<String>, position: Int): String {
        var numOnes = 0;
        var numZeros = 0;
        for (line in input) {
            if (line[position].toString() == "1") {
                numOnes++
            }
            else {
                numZeros++
            }
        }
        return if (numOnes > numZeros) {
            "1"
        } else if (numZeros > numOnes) {
            "0"
        } else {
            "same"
        }
    }

    fun part2(input: List<String>): Int {
        var oxygenRating = input.toList()
        for (position in oxygenRating[0].indices) {
            val mostCommonBit = getMostCommonBitInPosition(oxygenRating, position)
            oxygenRating = if (mostCommonBit == "same") {
                oxygenRating.filter { it[position].toString() == "1" }
            } else {
                oxygenRating.filter { it[position].toString() == mostCommonBit }
            }
            if (oxygenRating.size == 1) {
                break;
            }
        }

        var co2Rating = input.toList()
        for (position in co2Rating[0].indices) {
            val mostCommonBit = getMostCommonBitInPosition(co2Rating, position)
            co2Rating = when (mostCommonBit) {
                "1" -> {
                    co2Rating.filter { it[position].toString() == "0" }
                }
                "0" -> {
                    co2Rating.filter { it[position].toString() == "1" }
                }
                else -> {
                    co2Rating.filter{ it[position].toString() == "0"}
                }
            }
            if (co2Rating.size == 1) {
                break;
            }
        }
        return byteStringToInt(oxygenRating.first()) * byteStringToInt(co2Rating.first())
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
