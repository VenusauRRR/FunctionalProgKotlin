package Y2022.Day6

import org.testng.AssertJUnit.assertEquals
import org.testng.annotations.Test

class Day6TuningTroubleTest {
    val tt = TuningTrouble("src/test/kotlin/Y2022/Day6/Input1")
    val tt1 = TuningTrouble("src/test/kotlin/Y2022/Day6/Input2")
    val tt2 = TuningTrouble("src/test/kotlin/Y2022/Day6/Input3")
    val tt3 = TuningTrouble("src/test/kotlin/Y2022/Day6/Input4")
    val tt4 = TuningTrouble("src/test/kotlin/Y2022/Day6/Input5")

    @Test
    fun part1findIndexTest(){
        assertEquals(7,tt.part1findIndex())
        assertEquals(5,tt1.part1findIndex())
        assertEquals(6,tt2.part1findIndex())
        assertEquals(10,tt3.part1findIndex())
        assertEquals(11,tt4.part1findIndex())
    }
}