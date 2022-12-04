import java.io.File
import java.lang.Exception

class DayFour {

    fun part1() {
        val input = File("src/main/resources/Day4").useLines { it.toList() }
        var score = 0
        input.forEach {
            val first = it.split(',')[0]
            val second = it.split(',')[1]

            var firstList = mutableListOf<Int>()
            var secondList = mutableListOf<Int>()

            for (i in first.split('-')[0].toInt()..first.split('-')[1].toInt()) {
                firstList.add(i)
            }
            for (i in second.split('-')[0].toInt()..second.split('-')[1].toInt()) {
                secondList.add(i)
            }
            var contains = 1
            if (firstList.size <= secondList.size) {
                firstList.forEach {
                    if (!secondList.contains(it)) {
                        contains = 0
                    }
                }
            } else {
                secondList.forEach {
                    if(!firstList.contains(it)) {
                        contains = 0
                    }
                }
            }
            score+=contains
        }
        println("Part1: $score")
    }

    fun part2() {
        val input = File("src/main/resources/Day4").useLines { it.toList() }
        var score = 0
        input.forEach {
            val first = it.split(',')[0]
            val second = it.split(',')[1]

            var firstList = mutableListOf<Int>()
            var secondList = mutableListOf<Int>()

            for (i in first.split('-')[0].toInt()..first.split('-')[1].toInt()) {
                firstList.add(i)
            }
            for (i in second.split('-')[0].toInt()..second.split('-')[1].toInt()) {
                secondList.add(i)
            }
            var contains = 0
            if (firstList.size <= secondList.size) {
                firstList.forEach {
                    if (secondList.contains(it)) {
                        contains = 1
                    }
                }
            } else {
                secondList.forEach {
                    if(firstList.contains(it)) {
                        contains = 1
                    }
                }
            }
            score+=contains
        }
        println("Part2: $score")
    }
}