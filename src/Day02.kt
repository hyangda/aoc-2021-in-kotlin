fun main() {
    class Submarine {
        var horizontalPosition = 0
        var depth = 0
        var aim = 0

        fun moveSubmarine(command: List<String>) {
            val direction = command.first()
            val value = command.last().toInt()

            when(direction) {
                "forward" -> this.horizontalPosition += value
                "up" -> this.depth -= value
                "down" -> this.depth += value
                else -> println("What the dog doin: $direction $depth")
            }
        }

        private fun aimForward(value: Int) {
            this.horizontalPosition += value
            this.depth += this.aim * value
        }

        fun moveSubmarineV2FinalEditedDocx(command: List<String>) {
            val direction = command.first()
            val value = command.last().toInt()

            when(direction) {
                "forward" -> this.aimForward(value)
                "up" -> this.aim -= value
                "down" -> this.aim += value
                else -> println("What the dog doin: $direction $depth")
            }
        }
    }

    fun part1(input: List<String>): Int {
        val sub = Submarine()
        for (command in input) {
            sub.moveSubmarine(command.split(" "))
        }
        return sub.horizontalPosition * sub.depth
    }

    fun part2(input: List<String>): Int {
        val sub = Submarine()
        for (command in input) {
            sub.moveSubmarineV2FinalEditedDocx(command.split(" "))
        }
        return sub.horizontalPosition * sub.depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
