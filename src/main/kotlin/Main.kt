fun main() {

    println("Willkommen aus Advent Of Code 2022")

    while (true) {
        println("Välj dag för att köra grejerna, skriv t.ex 1 för dag1")

        when (readln()) {
            "1" -> {
                DayOne().part1()
                DayOne().part2()
                break
            }
            "2" -> {
                DayTwo().part1()
                DayTwo().part2()
            }
            else -> println("????? try again")
        }
    }
}