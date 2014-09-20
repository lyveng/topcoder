package srm628.division1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivisorsPowerTest {

    protected DivisorsPower solution;

    @Before
    public void setUp() {
        solution = new DivisorsPower();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        long n = 4L;

        long expected = 2L;
        long actual = solution.findArgument(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        long n = 10L;

        long expected = -1L;
        long actual = solution.findArgument(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 20000000)
    public void testCase2() {
        long n = 64L;

        long expected = 4L;
        long actual = solution.findArgument(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 20000000)
    public void testCase3() {
        long n = 10000L;

        long expected = 10L;
        long actual = solution.findArgument(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        long n = 2498388559757689L;

        long expected = 49983883L;
        long actual = solution.findArgument(n);

        Assert.assertEquals(expected, actual);
    }

}
