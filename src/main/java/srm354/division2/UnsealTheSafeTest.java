package srm354.division2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnsealTheSafeTest {

    protected UnsealTheSafe solution;

    @Before
    public void setUp() {
        solution = new UnsealTheSafe();
    }

    @Test(timeout = 20000000)
    public void testCase0() {
        int N = 2;

        long expected = 26L;
        long actual = solution.countPasswords(N);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int N = 3;

        long expected = 74L;
        long actual = solution.countPasswords(N);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int N = 25;

        long expected = 768478331222L;
        long actual = solution.countPasswords(N);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 20000000)
    public void testCase3() {
        int N = 1;

        long expected = 10L;
        long actual = solution.countPasswords(N);

        Assert.assertEquals(expected, actual);
    }
}
