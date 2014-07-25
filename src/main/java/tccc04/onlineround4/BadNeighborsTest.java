package tccc04.onlineround4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BadNeighborsTest {

    protected BadNeighbors solution;

    @Before
    public void setUp() {
        solution = new BadNeighbors();
    }

    @Test(timeout = 200000000)
    public void testCase0() {
        int[] donations = new int[]{10, 3, 2, 5, 7, 8};

        int expected = 19;
        int actual = solution.maxDonations(donations);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] donations = new int[]{11, 15};

        int expected = 15;
        int actual = solution.maxDonations(donations);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] donations = new int[]{7, 7, 7, 7, 7, 7, 7};

        int expected = 21;
        int actual = solution.maxDonations(donations);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] donations = new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5};

        int expected = 16;
        int actual = solution.maxDonations(donations);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] donations = new int[]{94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72};

        int expected = 2926;
        int actual = solution.maxDonations(donations);

        Assert.assertEquals(expected, actual);
    }

}
