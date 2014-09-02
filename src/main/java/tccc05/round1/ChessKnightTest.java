package tccc05.round1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChessKnightTest {

    protected ChessKnight solution;

    @Before
    public void setUp() {
        solution = new ChessKnight();
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
        int x = 1;
        int y = 1;
        int n = 2;

        double expected = 0.1875;
        double actual = solution.probability(x, y, n);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int x = 4;
        int y = 4;
        int n = 1;

        double expected = 1.0;
        double actual = solution.probability(x, y, n);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int x = 2;
        int y = 3;
        int n = 10;

        double expected = 0.0522148497402668;
        double actual = solution.probability(x, y, n);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int x = 4;
        int y = 3;
        int n = 50;

        double expected = 8.356427906809618E-7;
        double actual = solution.probability(x, y, n);

        assertEquals(expected, actual);
    }

}
