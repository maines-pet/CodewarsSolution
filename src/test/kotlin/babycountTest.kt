import kotlin.test.assertEquals
import org.junit.Test

class TestWillYou {
    @Test
    fun testFixed() {
        assertEquals(1, babyCount("baby"))
        assertEquals(1, babyCount("abby"))
        assertEquals(3, babyCount("baby baby baby"))
        assertEquals(1, babyCount("Why the hell are there so many babies?!"))
        assertEquals(1, babyCount("Anyone remember life before babies?"))
        assertEquals(2, babyCount("Happy babies boom ba by?"))
        assertEquals(1, babyCount("b a b y"))
        assertEquals(null, babyCount(""))
        assertEquals(null, babyCount("none her"))
        assertEquals(null, babyCount("bby"))
    }
}
