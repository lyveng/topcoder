package tccc03.semifinals3;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ZigZagTest {

    protected ZigZag solution;

    @Before
    public void setUp() {
        solution = new ZigZag();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] sequence = new int[]{1, 7, 4, 9, 2, 5};

        int expected = 6;
        int actual = solution.longestZigZag(sequence);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] sequence = new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};

        int expected = 7;
        int actual = solution.longestZigZag(sequence);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] sequence = new int[]{44};

        int expected = 1;
        int actual = solution.longestZigZag(sequence);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] sequence = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        int expected = 2;
        int actual = solution.longestZigZag(sequence);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] sequence = new int[]{70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32};

        int expected = 8;
        int actual = solution.longestZigZag(sequence);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int[] sequence = new int[]{374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 249, 22, 176, 279, 23, 22, 617, 462, 459, 244};

        int expected = 36;
        int actual = solution.longestZigZag(sequence);

        Assert.assertEquals(expected, actual);
    }

}
