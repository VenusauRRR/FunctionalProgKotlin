package Y2022.Day8

import java.io.File
import kotlin.math.max

class TreeHouse_New(val path: String){
    val data = File(path).readLines()

    //reference from: https://github.com/Davio/advent-of-code/blob/main/src/main/kotlin/com/github/davio/aoc/y2022/Day8.kt
    private fun parseGrid(): List<List<Int>> = data.map { it.map { it.digitToInt() } }
    val totalCol = parseGrid().get(0).size
    val totalRow = parseGrid().size

    fun checkIfTreeVisible(rowIndex: Int, colIndex: Int): Int{

        //find the trees at different directions and put into a list

        val topMax = parseGrid().take(rowIndex).map { it.get(colIndex) }.max()

        val bottomMax = parseGrid().drop(rowIndex+1).map { it.get(colIndex) }.max()

        val leftMax = parseGrid().get(rowIndex).take(colIndex).max()

        val rightMax = parseGrid().get(rowIndex).drop(colIndex+1).max()

        val treeValue = parseGrid().get(rowIndex).get(colIndex)

        //compare the max value at each direction and compare to the target tree value

        if (treeValue>topMax ||
            treeValue>bottomMax ||
            treeValue>leftMax ||
            treeValue>rightMax)
            return 1 else return 0
    }
    fun part1findVisibleTreeAmt(): Int{
        var sum = 0
        val treeOnTheEdge = data.get(0).length*2+(data.size-2)*2

        for (i in 1..totalRow-2){
            for (j in 1..totalCol-2){
                sum += checkIfTreeVisible(i,j)
            }
        }
        return sum+treeOnTheEdge
    }
}
fun main() {
    val t = TreeHouse_New("src/main/kotlin/Y2022/Day8/Day8Input")
    println( t.part1findVisibleTreeAmt())
}