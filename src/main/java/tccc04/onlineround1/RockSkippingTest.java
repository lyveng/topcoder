package tccc04.onlineround1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RockSkippingTest {

    protected RockSkipping solution;

    @Before
    public void setUp() {
        solution = new RockSkipping();
    }

    public static void assertEquals(double expected, double actual) {
        if (Double.isNaN(expected)) {
            Assert.assertTrue("expected: <NaN> but was: <" + actual + ">", Double.isNaN(actual));
            return;
        }
        double delta = Math.max(1e-9, 1e-9 * Math.abs(expected));
        Assert.assertEquals(expected, actual, delta);
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String pads = ".";
        int maxDist = 100;

        double expected = 100.0;
        double actual = solution.probability(pads, maxDist);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String pads = "...X";
        int maxDist = 2;

        double expected = 50.0;
        double actual = solution.probability(pads, maxDist);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String pads = "........................X";
        int maxDist = 50;

        double expected = 11.60725450562586;
        double actual = solution.probability(pads, maxDist);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String pads = "...X......XXXX...XX.X..X...XX...";
        int maxDist = 48;

        double expected = 5.408479511004734E-8;
        double actual = solution.probability(pads, maxDist);

        assertEquals(expected, actual);
    }

}
