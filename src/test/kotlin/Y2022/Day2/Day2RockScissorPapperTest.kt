package Y2022.Day2

import Y2022.Day2.RockScissorPapper
import org.testng.AssertJUnit.assertEquals
import org.testng.annotations.Test

class Day2RockScissorPapperTest {
    val rsp = RockScissorPapper("src/test/kotlin/Y2022/Day2/Day2Input")

    @Test
    fun calculatePart1Test(){
        val actual = rsp.calculatePart1()
        assertEquals(15,actual)
    }

    @Test
    fun calculatePart2Test(){
        val actual = rsp.calculatePart2()
        assertEquals(12,actual)
    }
}