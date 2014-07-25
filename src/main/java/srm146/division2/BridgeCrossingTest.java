package srm146.division2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BridgeCrossingTest {

    protected BridgeCrossing solution;

    @Before
    public void setUp() {
        solution = new BridgeCrossing();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] times = new int[]{1, 2, 5, 10};

        int expected = 17;
        int actual = solution.minTime(times);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] times = new int[]{1, 2, 3, 4, 5};

        int expected = 16;
        int actual = solution.minTime(times);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] times = new int[]{100};

        int expected = 100;
        int actual = solution.minTime(times);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] times = new int[]{1, 2, 3, 50, 99, 100};

        int expected = 162;
        int actual = solution.minTime(times);

        Assert.assertEquals(expected, actual);
    }

}
