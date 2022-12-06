package main.kotlin

import java.io.File

class DaySix {
    fun part1() {
        val input = File("src/main/resources/Day6").readText()
        extracted(input, 4)
    }
    fun part2() {
        val input = File("src/main/resources/Day6").readText()
        extracted(input, 14)
    }
    private fun extracted(input: String, windowSize: Int) {
        run breaking@{
            input.windowed(windowSize).forEachIndexed { index, window ->
                if (window.toSet().size == window.length) {
                    println("${index + windowSize}")
                    return@breaking
                }
            }
        }
    }
}