package Y2022.Day1

import java.io.File

class Calorie (val path: String){
    val data: List<String> = File(path).readLines()
    var tempList = ArrayList<Int>()
    val calculateData = calculateData()
    fun calculateData(){
        var tempSum = 0
        var count = 0
        data
            .forEach {
                if (it.isNullOrBlank())
                {
                    tempList.add(tempSum)
                    tempSum = 0
                } else {
                    tempSum += it.toInt()
                }
                count++
                if (count==data.size){
                    tempList.add(tempSum)
                }
            }
    }

    fun getMaxCalorie(): Int{
        return tempList.max()
    }

    fun getMax3CalorieSum(): Int{
        return tempList.sortedDescending().subList(0,3).sum()
    }
}
    fun main(){
        val calorie = Calorie("src/main/kotlin/Y2022/Day1/Day1Input")
        println(calorie.getMaxCalorie()) //part A
        println(calorie.getMax3CalorieSum()) //part B
    }
