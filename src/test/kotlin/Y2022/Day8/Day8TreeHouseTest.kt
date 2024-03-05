package Y2022.Day8

import org.testng.AssertJUnit.assertEquals
import org.testng.annotations.Test

class Day8TreeHouseTest{
    val t = TreeHouse("src/test/kotlin/Y2022/Day8/Day8Input")

    @Test
    fun part1findVisibleTreeAmtTest(){
        assertEquals(21,t.part1findVisibleTreeAmt())
    }
}