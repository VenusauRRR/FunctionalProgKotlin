package Y2022.Day3

import java.io.File

class Rucksack_New(val path: String){
    val data = File(path).readLines()

    //reference from: https://github.com/daathz/AOC_2022/blob/master/src/main/kotlin/Day03.kt

    val lowercase = "abcdefghijklmnopqrstuvwxyz"
    val totalCase = lowercase + lowercase.uppercase()

    fun getItemTypeValue(c: Char):Int{
        return totalCase.indexOf(c)+1
    }

    fun part1findAmt(): Int{
        return data
            .map {listOf(it.substring(0,it.length/2),it.substring(it.length/2,it.length))}
            .map { it.map { it.toList().distinct() } }
            .flatMap { it.get(0).intersect(it.get(1)) }
            .sumOf { getItemTypeValue(it) }
    }

    fun part2findAmt():Int{
        return data
            .chunked(3)
            .map { it.map { it.toList().distinct() } }
            .flatMap { it.get(0).intersect(it.get(1)).intersect(it.get(2))}
            .sumOf { getItemTypeValue(it) }
    }
}

fun main() {
    val rs = Rucksack_New("src/main/kotlin/Y2022/Day3/Day3Input")
    println(rs.part1findAmt())
    println(rs.part2findAmt())
}