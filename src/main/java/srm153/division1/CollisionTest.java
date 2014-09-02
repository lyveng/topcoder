package srm153.division1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CollisionTest {

    protected Collision solution;

    @Before
    public void setUp() {
        solution = new Collision();
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
        int[] assignments = new int[]{20, 20};
        int ids = 1000;

        double expected = 0.2113618990410422;
        double actual = solution.probability(assignments, ids);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] assignments = new int[]{123, 456};
        int ids = 123456;

        double expected = 0.3769052883184334;
        double actual = solution.probability(assignments, ids);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] assignments = new int[]{10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000};
        int ids = 2147483647;

        double expected = 0.0069090268185510555;
        double actual = solution.probability(assignments, ids);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] assignments = new int[]{1005, 1005};
        int ids = 1000;

        double expected = 0.0;
        double actual = solution.probability(assignments, ids);

        assertEquals(expected, actual);
    }

}
