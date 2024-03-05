package Y2022.Day2

import java.io.File
import java.lang.NullPointerException
import java.util.IllegalFormatCodePointException

class RockScissorPapper(val path: String){
    val data: String = File(path).readText()
    val scoreMapPart1 = mapOf("A" to 1, "B" to 2, "C" to 3, "X" to 1, "Y" to 2, "Z" to 3)
    val scoreMapPart2 = mapOf("A" to 1, "B" to 2, "C" to 3, "X" to 0, "Y" to 3, "Z" to 6)
    fun calculatePart1(): Int{
        return data
            .trim()
            .split("\r\n")
            .map { it.trim().split(" ").map { scoreMapPart1.getValue(it)}}
            .sumOf { it.get(1)+findRoundScore(it) }
    }

    fun calculatePart2(): Int{
        return data
            .trim()
        .split("\r\n")
        .map { it.trim().split(" ").map { scoreMapPart2.getValue(it)}}
        .sumOf { findChoice(it)+it.get(1) }
    }

    fun findRoundScore(round: List<Int>): Int{
        val result = round.get(1)-round.get(0)
        if (result==1 || result==-2) {
            return 6
        } else if (result==0){
            return 3
        } else return 0
    }

    fun findChoice(round: List<Int>): Int{
        val opponent = round.get(0)
        val result = round.get(1)
        if (result==0){ //X: lose
            if (opponent==2 || opponent==3) return opponent-1 else return opponent+2
        } else if (result==6){ //Z: win
            if (opponent==3) return opponent-2 else return opponent+1
        } else return opponent //Y: draw
    }
}

fun main() {
    val rsp = RockScissorPapper("src/main/kotlin/Y2022/Day2/Day2Input")
    println(rsp.calculatePart1())
    println(rsp.calculatePart2())
}