package tco04.onlineround3;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VolleyballTest {

    protected Volleyball solution;

    @Before
    public void setUp() {
        solution = new Volleyball();
    }

    public static void assertEquals(double expected, double actual) {
        if (Double.isNaN(expected)) {
            Assert.assertTrue("expected: <NaN> but was: <" + actual + ">", Double.isNaN(actual));
            return;
        }
        double delta = Math.max(1e-9, 1e-9 * Math.abs(expected));
        Assert.assertEquals(expected, actual, delta);
    }

    @Test(timeout = 20000000)
    public void testCase0() {
        int sScore = 13;
        int rScore = 13;
        double probWinServe = 0.5;

        double expected = 0.5;
        double actual = solution.win(sScore, rScore, probWinServe);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int sScore = 1;
        int rScore = 14;
        double probWinServe = 0.01;

        double expected = 3.355704697986578E-27;
        double actual = solution.win(sScore, rScore, probWinServe);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int sScore = 8;
        int rScore = 12;
        double probWinServe = 0.4;

        double expected = 0.046377890909090946;
        double actual = solution.win(sScore, rScore, probWinServe);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int sScore = 4;
        int rScore = 3;
        double probWinServe = 0.01;

        double expected = 0.6662085066547871;
        double actual = solution.win(sScore, rScore, probWinServe);

        assertEquals(expected, actual);
    }

}
