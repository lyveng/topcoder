package tco03.onlineround4;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JewelryTest {

    protected Jewelry solution;

    @Before
    public void setUp() {
        solution = new Jewelry();
    }

    @Test(timeout = 2000000000)
    public void testCase0() {
        int[] values = new int[]{1, 2, 5, 3, 4, 5};

        long expected = 9L;
        long actual = solution.howMany(values);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 200000000)
    public void testCase1() {
        int[] values = new int[]{1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};

        long expected = 18252025766940L;
        long actual = solution.howMany(values);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] values = new int[]{1, 2, 3, 4, 5};

        long expected = 4L;
        long actual = solution.howMany(values);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] values = new int[]{7, 7, 8, 9, 10, 11, 1, 2, 2, 3, 4, 5, 6};

        long expected = 607L;
        long actual = solution.howMany(values);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] values = new int[]{123, 217, 661, 678, 796, 964, 54, 111, 417, 526, 917, 923};

        long expected = 0L;
        long actual = solution.howMany(values);

        Assert.assertEquals(expected, actual);
    }

}
