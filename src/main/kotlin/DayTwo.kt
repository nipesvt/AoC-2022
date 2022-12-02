import java.io.File
import java.lang.Exception

class DayTwo {

    fun part1() {
        val input = File("src/main/resources/Day2").useLines { it.toList() }
        var gameScore = 0
        input.forEach {
            println(choosenPoint(it[2]) + gamePoint(it[2], it[0]))
            gameScore += choosenPoint(it[2]) + gamePoint(it[2], it[0])
        }
        println("Part1 : $gameScore")
    }

    fun part2() {
        val input = File("src/main/resources/Day2").useLines { it.toList() }
        var gameScore = 0
        input.forEach {
            val me = it[2]
            val opponent = it[0]
            if (me == 'X') {
                gameScore += loosingScore(opponent)
            } else if (me == 'Y') {
                gameScore += 3
                gameScore += drawScore(opponent)
            } else {
                gameScore += 6
                gameScore += winScore(opponent)
            }
        }
        println("Part2 : $gameScore")
    }

    private fun winScore(opponent: Char): Int {
        return if (opponent == 'A') {
            2
        } else if (opponent == 'B') {
            3
        } else {
            1
        }
    }

    private fun drawScore(opponent: Char): Int {
        return if (opponent == 'A') {
            1
        } else if (opponent == 'B') {
            2
        } else {
            3
        }
    }

    private fun loosingScore(opponent: Char): Int {
        return if (opponent == 'A') {
            3
        } else if (opponent == 'B') {
            1
        } else {
            2
        }
    }


    fun gamePoint(me: Char, opponent: Char): Int {
        return if (isDraw(me, opponent)) {
            3
        } else if (me == 'X' && opponent == 'C') {
            6
        } else if (me == 'Y' && opponent == 'A') {
            6
        } else if (me == 'Z' && opponent == 'B') {
            6
        } else {
            0
        }
    }

    fun isDraw(me: Char, opponent: Char): Boolean {
        return if (me == 'X' && opponent == 'A') {
            true
        } else if (me == 'Y' && opponent == 'B') {
            true
        } else me == 'Z' && opponent == 'C'
    }

    fun choosenPoint(choosen: Char): Int {
        return when (choosen) {
            'X' -> 1
            'Y' -> 2
            'Z' -> 3
            else -> throw Exception()
        }
    }
}