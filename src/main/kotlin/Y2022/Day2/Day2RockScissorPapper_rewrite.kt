package Y2022.Day2

import java.io.File
import java.lang.NullPointerException
import java.util.IllegalFormatCodePointException

class RockScissorPapper_New(val path: String){

    //Reference from: https://github.com/marcdejonge/advent2022/blob/main/src/main/kotlin/marcdejonge/advent2022/Day2.kt

    val data: String = File(path).readText()
    fun calculatePart1(): Int{
        return data
            .split("\r\n")
            .sumOf {parseChoice(it.get(2)).score + findRoundScore(parseChoice(it.get(0)),parseChoice(it.get(2))) }
    }

    fun calculatePart2(): Int{
        return data
            .split("\r\n")
            .sumOf { findChoice(it.get(2),it.get(0)).score + findRoundScore(parseChoice(it.get(0)),findChoice(it.get(2),it.get(0))) }
    }
    fun parseChoice(choice: Char): Choice{
        when (choice){
            'A','X' -> return Choice.Rock
            'B','Y' -> return Choice.Paper
            'C','Z' -> return Choice.Scissor
            else -> error("unknown character")
        }
    }
    enum class Choice (val score: Int){
        Rock (1),
        Paper (2),
        Scissor (3);

        val losingChoice
            get() = when (this){
                Rock -> Scissor
                Paper -> Rock
                Scissor -> Paper
            }

        val winningChoice
            get() = when (this) {
                Rock -> Paper
                Paper -> Scissor
                Scissor -> Rock
            }
    }

    fun findRoundScore(opponent: Choice, me: Choice): Int{
        when (me) {
            opponent -> return 3
            opponent.winningChoice -> return 6
            opponent.losingChoice -> return 0
            else -> error("unknown character")
        }
    }
    fun findChoice(round: Char, opponentChoice: Char): Choice{
        val opponent = parseChoice(opponentChoice)
        when (round){
            'X' -> return opponent.losingChoice
            'Y' -> return opponent
            'Z' -> return opponent.winningChoice
            else -> error("unknown char")
        }
    }
}

fun main() {
    val rsp = RockScissorPapper_New("src/main/kotlin/Y2022/Day2/Day2Input")
    println(rsp.calculatePart1())
    println(rsp.calculatePart2())
}