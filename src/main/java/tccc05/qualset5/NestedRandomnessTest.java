package tccc05.qualset5;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NestedRandomnessTest {

    protected NestedRandomness solution;

    @Before
    public void setUp() {
        solution = new NestedRandomness();
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
        int N = 5;
        int nestings = 2;
        int target = 1;

        double expected = 0.21666666666666667;
        double actual = solution.probability(N, nestings, target);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int N = 10;
        int nestings = 4;
        int target = 0;

        double expected = 0.19942680776014104;
        double actual = solution.probability(N, nestings, target);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int N = 1000;
        int nestings = 10;
        int target = 990;

        double expected = 1.0461776397050886E-30;
        double actual = solution.probability(N, nestings, target);

        assertEquals(expected, actual);
    }

}
