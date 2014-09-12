package tco04.onlineround3;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoxingTest {

    protected Boxing solution;

    @Before
    public void setUp() {
        solution = new Boxing();
    }

    @Test(timeout = 2000000)
    public void testCase0() {
        int[] a = new int[]{1, 2, 3, 4, 5, 6};
        int[] b = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] c = new int[]{1, 2, 3, 4, 5, 6};
        int[] d = new int[]{0, 1, 2};
        int[] e = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

        int expected = 6;
        int actual = solution.maxCredit(a, b, c, d, e);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] a = new int[]{100, 200, 300, 1200, 6000};
        int[] b = new int[]{};
        int[] c = new int[]{900, 902, 1200, 4000, 5000, 6001};
        int[] d = new int[]{0, 2000, 6002};
        int[] e = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

        int expected = 3;
        int actual = solution.maxCredit(a, b, c, d, e);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] a = new int[]{5000, 6500};
        int[] b = new int[]{6000};
        int[] c = new int[]{6500};
        int[] d = new int[]{6000};
        int[] e = new int[]{0, 5800, 6000};

        int expected = 1;
        int actual = solution.maxCredit(a, b, c, d, e);

        Assert.assertEquals(expected, actual);
    }

}
