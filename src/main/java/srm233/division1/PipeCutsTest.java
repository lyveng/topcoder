package srm233.division1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PipeCutsTest {

    protected PipeCuts solution;

    @Before
    public void setUp() {
        solution = new PipeCuts();
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
        int[] weldLocations = new int[]{25, 50, 75};
        int L = 25;

        double expected = 1.0;
        double actual = solution.probability(weldLocations, L);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] weldLocations = new int[]{25, 50, 75};
        int L = 50;

        double expected = 0.0;
        double actual = solution.probability(weldLocations, L);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] weldLocations = new int[]{25, 50, 75};
        int L = 24;

        double expected = 1.0;
        double actual = solution.probability(weldLocations, L);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] weldLocations = new int[]{99, 88, 77, 66, 55, 44, 33, 22, 11};
        int L = 50;

        double expected = 0.7222222222222222;
        double actual = solution.probability(weldLocations, L);

        assertEquals(expected, actual);
    }

}
