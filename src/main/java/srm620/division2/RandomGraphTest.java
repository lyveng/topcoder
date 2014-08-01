package srm620.division2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RandomGraphTest {

    protected RandomGraph solution;

    @Before
    public void setUp() {
        solution = new RandomGraph();
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
        int n = 7;
        int p = 0;

        double expected = 0.0;
        double actual = solution.probability(n, p);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int n = 3;
        int p = 620;

        double expected = 0.0;
        double actual = solution.probability(n, p);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int n = 4;
        int p = 500;

        double expected = 0.59375;
        double actual = solution.probability(n, p);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int n = 8;
        int p = 100;

        double expected = 0.33566851611343496;
        double actual = solution.probability(n, p);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int n = 15;
        int p = 50;

        double expected = 0.5686761670525845;
        double actual = solution.probability(n, p);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int n = 50;
        int p = 10;

        double expected = 0.7494276522159893;
        double actual = solution.probability(n, p);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase6() {
        int n = 50;
        int p = 1000;

        double expected = 1.0;
        double actual = solution.probability(n, p);

        assertEquals(expected, actual);
    }

}
