package Y2022.Day1

import Y2022.Day1.Calorie
import org.testng.AssertJUnit.assertEquals
import org.testng.annotations.Test

class Day1CalorieTest {
        val calorie = Calorie("src/test/kotlin/Y2022/Day1/Day1Input")
    @Test
    fun getMaxCalorieTest(){
        val actual = calorie.getMaxCalorie()
        assertEquals(24000,actual)
    }

    @Test
    fun getMax3CalorieSumTest(){
        val actual = calorie.getMax3CalorieSum()
        assertEquals(45000,actual)
    }
}