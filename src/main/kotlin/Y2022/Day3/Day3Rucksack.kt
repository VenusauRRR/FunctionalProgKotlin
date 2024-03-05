package Y2022.Day3

import java.io.File

class Rucksack(val path: String){
    val data = File(path).readLines()

    val lowercase = "abcdefghijklmnopqrstuvwxyz"
    val totalCase = lowercase + lowercase.uppercase()

    fun getItemTypeValue(c: Char?):Int{
        if (c != null)
        return totalCase.indexOf(c)+1 else return error("no such char")
    }

    fun part1findItemType(s: String): Char? {
        val half = s.length/2
        val set1 = s.take(half).toCharArray().distinct()
        val set2 = s.drop(half).toCharArray().distinct()
        val map = (set1+set2).groupBy { it }.map { it.value.size to it.key }.toMap()
        return map.get(2)
    }

    fun part1findAmt(): Int{
        return data
            .sumOf { getItemTypeValue(part1findItemType(it)) }
    }

    fun part2findItemType(s1:String, s2:String, s3: String): Char?{
        val set1 = s1.toCharArray().distinct()
        val set2 = s2.toCharArray().distinct()
        val set3 = s3.toCharArray().distinct()
        val map = (set1+set2+set3).groupBy { it }.map{it.value.size to it.key}.toMap()
        return map.get(3)
    }

    fun part2findAmt():Int{
        return data
            .windowed(3,3)
            .sumOf { getItemTypeValue(part2findItemType(it.get(0),it.get(1),it.get(2))) }
    }
}

fun main() {
    val rs = Rucksack("src/main/kotlin/Y2022/Day3/Day3Input")
    println(rs.part1findAmt())
    println(rs.part2findAmt())
}