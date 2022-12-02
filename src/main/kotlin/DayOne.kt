import java.io.File

class DayOne {
    fun part1() {
        val input = File("src/main/resources/Day1").useLines { it.toList() }
        var highestCalories = 0
        var localHighest = 0
        input.forEachIndexed { index, value ->
            if(value.isNotBlank() && value.isNotEmpty()) {
                localHighest = localHighest.plus(value.toInt())
            } else {
                if(localHighest > highestCalories) {
                    highestCalories = localHighest
                }
                localHighest = 0
            }
            if(index == input.size-1) {
                if(localHighest > highestCalories) {
                    highestCalories = localHighest
                }
            }
        }
        println("Part1: $highestCalories")
    }

    fun part2() {
        val input = File("src/main/resources/Day1").useLines { it.toList() }
        var highestCalories = 0
        var highestCalories2 = 0
        var highestCalories3 = 0
        var localHighest = 0
        input.forEachIndexed { index, value ->
            if(value.isNotBlank() && value.isNotEmpty()) {
                localHighest = localHighest.plus(value.toInt())
            } else {
                if(localHighest > highestCalories) {
                    highestCalories3 = highestCalories2
                    highestCalories2 = highestCalories
                    highestCalories = localHighest
                } else if (localHighest > highestCalories2) {
                    highestCalories3 = highestCalories2
                    highestCalories2 = localHighest
                } else if (localHighest > highestCalories3) {
                    highestCalories3 = localHighest
                }
                localHighest = 0
            }
            if(index == input.size-1) {
                if(localHighest > highestCalories) {
                    highestCalories3 = highestCalories2
                    highestCalories2 = highestCalories
                    highestCalories = localHighest
                } else if (localHighest > highestCalories2) {
                    highestCalories3 = highestCalories2
                    highestCalories2 = localHighest
                } else if (localHighest > highestCalories3) {
                    highestCalories3 = localHighest
                }
            }
        }
        println("Part2: ${highestCalories+highestCalories2+highestCalories3}")
    }
}