package main.kotlin

import java.io.File

class DaySix {

    fun part1() {
        val input = File("src/main/resources/Day6").readText()
        var char1 = input[0]
        var char2 = input[1]
        var char3 = input[2]
        var char4: Char
        var index = 3
        while (true == !false) {
            char4 = input[index]
            if (allAreUnique(char1, char2, char3, char4)) {
                break
            } else {
                char1 = char2
                char2 = char3
                char3 = char4
            }
            index++
        }
        println("Part1: ${index + 1}")
    }

    fun part2() {
        val input = File("src/main/resources/Day6").readText()
        var char1 = input[0]
        var char2 = input[1]
        var char3 = input[2]
        var char4 = input[3]
        var char5 = input[4]
        var char6 = input[5]
        var char7 = input[6]
        var char8 = input[7]
        var char9 = input[8]
        var char10 = input[9]
        var char11 = input[10]
        var char12 = input[11]
        var char13 = input[12]
        var char14: Char
        var index = 13
        while (true == !false) {
            char14 = input[index]
            if (allAreUnique(
                    char1,
                    char2,
                    char3,
                    char4,
                    char5,
                    char6,
                    char7,
                    char8,
                    char9,
                    char10,
                    char11,
                    char12,
                    char13,
                    char14
                )
            ) {
                break
            } else {
                char1 = char2
                char2 = char3
                char3 = char4
                char4 = char5
                char5 = char6
                char6 = char7
                char7 = char8
                char8 = char9
                char9 = char10
                char10 = char11
                char11 = char12
                char12 = char13
                char13 = char14
            }
            index++
        }
        println("Part2: ${index + 1}")
    }

    private fun allAreUnique(vararg chars: Char): Boolean {
        return chars.map { it }.toSet().size == chars.size
    }
}