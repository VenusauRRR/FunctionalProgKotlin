package Y2022.Day6

import java.io.File

class TuningTrouble_New(val path: String){
    val data: String = File(path).readText()

    fun part1findIndex(): Int{
         return data
            .windowed(4,1)
            .indexOfFirst { it.toCharArray().distinct().size==4 } + 4
    }
}

fun main() {
    val tt = TuningTrouble_New("src/main/kotlin/Y2022/Day6/Day6Input")
    println( tt.part1findIndex())
}

