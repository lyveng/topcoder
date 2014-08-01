package srm165.division2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShortPalindromesTest {

    protected ShortPalindromes solution;

    @Before
    public void setUp() {
        solution = new ShortPalindromes();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String base = "RACE";

        String expected = "ECARACE";
        String actual = solution.shortest(base);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String base = "TOPCODER";

        String expected = "REDTOCPCOTDER";
        String actual = solution.shortest(base);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String base = "Q";

        String expected = "Q";
        String actual = solution.shortest(base);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String base = "MADAMIMADAM";

        String expected = "MADAMIMADAM";
        String actual = solution.shortest(base);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String base = "ALRCAGOEUAOEURGCOEUOOIGFA";

        String expected = "AFLRCAGIOEOUAEOCEGRURGECOEAUOEOIGACRLFA";
        String actual = solution.shortest(base);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String base = "ABA";

        String expected = "ABA";
        String actual = solution.shortest(base);

        Assert.assertEquals(expected, actual);
    }
}
