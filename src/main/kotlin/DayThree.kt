import java.io.File

class DayThree {

    fun part1() {
        val input = File("src/main/resources/Day3").useLines { it.toList() }
        var score = 0
        input.forEach {
            val rug1 = it.substring(0,it.length/2)
            val rug2 = it.substring(it.length/2)
            val duplicate = rug1.find { first -> rug2.any { second -> first.equals(second) } }
            score += computeScore(duplicate)
        }
        println("Part1: $score")
    }

    fun part2() {
        val input = File("src/main/resources/Day3").useLines { it.toList() }
        var index = 0
        var score = 0
        while(index < input.size) {
            var rug1 = input[index]
            var rug2 = input[index+1]
            var rug3 = input[index+2]
            val candidates = rug1.filter { first -> rug2.any { second -> first.equals(second) } }
            val duplicate = rug3.find { candidates.contains(it) }
            score += computeScore(duplicate)
            index+=3
        }
        println(("Part2: $score"))
    }

    private fun computeScore(duplicate: Char?): Int {
        if(duplicate == null) return 0
        var score = "abcdefghijklmnopqrstuvwxyz".indexOf(duplicate.lowercase()) +1
        if(duplicate.isUpperCase()) {
            score+=26
        }
        return score
    }
}