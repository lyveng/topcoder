package srm216.division1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RockStarTest {

    protected RockStar solution;

    @Before
    public void setUp() {
        solution = new RockStar();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int ff = 100;
        int fs = 0;
        int sf = 0;
        int ss = 200;

        int expected = 100;
        int actual = solution.getNumSongs(ff, fs, sf, ss);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int ff = 0;
        int fs = 0;
        int sf = 20;
        int ss = 200;

        int expected = 201;
        int actual = solution.getNumSongs(ff, fs, sf, ss);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int ff = 1;
        int fs = 2;
        int sf = 1;
        int ss = 1;

        int expected = 5;
        int actual = solution.getNumSongs(ff, fs, sf, ss);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int ff = 192;
        int fs = 279;
        int sf = 971;
        int ss = 249;

        int expected = 999;
        int actual = solution.getNumSongs(ff, fs, sf, ss);

        Assert.assertEquals(expected, actual);
    }

}
