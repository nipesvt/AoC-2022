package main.kotlin

import java.io.File

class DayFive {


    fun part1() {
        val input = File("src/main/resources/Day5").useLines { it.toList() }
        val moves = input.filter { it.isNotEmpty() && it[0].isLetter() }
        var crates = (input - moves.toSet()).filter { it.isNotEmpty()}
        crates = crates - crates.last()

        val stackList = mutableListOf<Stackeroo>()
        crates.forEach {
            var line = it
            var hasMoreCrates = true
            var stackNumber = 1
            while (hasMoreCrates) {
                var entry: String
                if (line.length >= 4) {
                    entry = line.take(4)
                    line = line.removeRange(0, 4)
                } else {
                    entry = line
                    hasMoreCrates = false
                }
                entry.filter { it.isLetter() }.let { crate ->
                    if (crate.isNotEmpty()) {
                        val stackeroo = stackList.find { it.index == stackNumber }
                        if (stackeroo != null) {
                            stackeroo.crates.addFirst(crate[0])
                        } else {
                            val newStack = Stackeroo(stackNumber, ArrayDeque())
                            newStack.crates.addFirst(crate[0])
                            stackList.add(newStack)
                        }
                    }
                }
                stackNumber++
            }
        }

        moves.forEach { command ->
            val digits = command.filter { it.isDigit() }
            val loopTo = digits.substring(0,digits.length-2)
            for (i in 1..loopTo.toInt()) {
                val crate = stackList.find { it.index == digits[digits.length-2].digitToInt() }!!.crates.removeLast()
                stackList.find { it.index == digits[digits.length-1].digitToInt()}!!.crates.addLast(crate)
            }
        }

        stackList.sortBy { it.index }
        val result = stackList.map { stackeroo -> stackeroo.crates.last() }
        println(result.joinToString(""))
    }


    fun part2() {
        val input = File("src/main/resources/Day5").useLines { it.toList() }
        val moves = input.filter { it.isNotEmpty() && it[0].isLetter() }
        var crates = (input - moves.toSet()).filter { it.isNotEmpty()}
        crates = crates - crates.last()

        val stackList = mutableListOf<Stackeroo>()
        crates.forEach {
            var line = it
            var hasMoreCrates = true
            var stackNumber = 1
            while (hasMoreCrates) {
                var entry: String
                if (line.length >= 4) {
                    entry = line.take(4)
                    line = line.removeRange(0, 4)
                } else {
                    entry = line
                    hasMoreCrates = false
                }
                entry.filter { it.isLetter() }.let { crate ->
                    if (crate.isNotEmpty()) {
                        val stackeroo = stackList.find { it.index == stackNumber }
                        if (stackeroo != null) {
                            stackeroo.crates.addFirst(crate[0])
                        } else {
                            val newStack = Stackeroo(stackNumber, ArrayDeque())
                            newStack.crates.addFirst(crate[0])
                            stackList.add(newStack)
                        }
                    }
                }
                stackNumber++
            }
        }

        moves.forEach { command ->
            val digits = command.filter { it.isDigit() }
            val amountOfCratesToMove = digits.substring(0,digits.length-2).toInt()
            val stackToTakeFrom = stackList.find { it.index == digits[digits.length - 2].digitToInt() }!!
            val cratesToMove = stackToTakeFrom.crates.subList(
                    stackToTakeFrom.crates.size  - amountOfCratesToMove,
            stackToTakeFrom.crates.size
            )
            val stackToGiveTo = stackList.find { it.index == digits[digits.length-1].digitToInt()}!!
            cratesToMove.forEach {
                stackToGiveTo.crates.addLast(it)
            }
            repeat(amountOfCratesToMove) {
                stackToTakeFrom.crates.removeLast()
            }

        }

        stackList.sortBy { it.index }
        val result = stackList.map { stackeroo -> stackeroo.crates.last() }
        println(result.joinToString(""))
    }

    data class Stackeroo(val index: Int, var crates: ArrayDeque<Char>) {

    }
}