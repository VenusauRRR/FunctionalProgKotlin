package Y2022.Day3

import org.testng.AssertJUnit.assertEquals
import org.testng.annotations.Test

class Day3RucksackTest {
    val rs = Rucksack("src/test/kotlin/Y2022/Day3/Day3Input")

    @Test
    fun part1findAmtTest(){
        assertEquals(157,rs.part1findAmt())
    }

    @Test
    fun part2findAmtTest(){
        assertEquals(70,rs.part2findAmt())

    }
}