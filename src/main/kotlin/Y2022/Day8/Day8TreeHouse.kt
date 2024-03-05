package Y2022.Day8

import java.io.File

class TreeHouse(val path: String){
    val data = File(path).readLines()

    fun isVisible(target: Int, ref: Int): Boolean{
        if (target>ref) return true else return false
    }

    fun getVerticalList(index: Int): List<Int>{
        return data.map { it.get(index).digitToInt() }
    }
    fun checkEachRowInsideTreeAmt(rowIndex: Int, rowString: String): Int{
        var counter = 0

        fun checktop (index: Int): Boolean{
            val l = getVerticalList(index)
            for (i in 0..rowIndex-1){
                if (isVisible(l.get(rowIndex),l.get(i))==false) return false
            }
            return true
        }

        fun checkBottom (index: Int): Boolean{
            val l = getVerticalList(index)
            for (i in rowIndex+1..l.size-1){
                if (isVisible(l.get(rowIndex),l.get(i))==false) return false
            }
            return true
        }

        fun checkLeft (index: Int): Boolean{
            val l = rowString
            for (i in 0..index-1){
                if (isVisible(l.get(index).digitToInt(),l.get(i).digitToInt())==false) return false
            }
            return true
        }

        fun checkRight (index: Int): Boolean{
            val l = rowString
            for (i in index+1..rowString.length-1 ){
                if (isVisible(l.get(index).digitToInt(),l.get(i).digitToInt())==false) return false
            }
            return true
        }

        for (i in 1..rowString.length-2){
            if (checktop(i)==true || checkBottom(i)==true || checkLeft(i)==true || checkRight(i)==true) counter++
        }
        return counter
    }

    fun part1findVisibleTreeAmt(): Int{
        val treeOnTheEdge = data.get(0).length*2+(data.size-2)*2
        return data
            .drop(1)
            .dropLast(1)
            .sumOf { checkEachRowInsideTreeAmt(data.indexOf(it),it)}+treeOnTheEdge
    }
}

fun main() {
    val t = TreeHouse("src/main/kotlin/Y2022/Day8/Day8Input")
    println( t.part1findVisibleTreeAmt())
}