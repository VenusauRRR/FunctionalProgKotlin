package Y2022.Day6

import java.io.File

class TuningTrouble(val path: String){
    val data: String = File(path).readText()

    fun part1findIndex(): Int{
        for (i in 3..data.length-1){
            if (data.substring(i-3,i+1).toCharArray().distinct().size==4) return i+1
        }
        return -1
    }
}

fun main() {
    val tt = TuningTrouble("src/main/kotlin/Y2022/Day6/Day6Input")
    println( tt.part1findIndex())
}