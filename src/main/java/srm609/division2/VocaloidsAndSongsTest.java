package srm609.division2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VocaloidsAndSongsTest {

    protected VocaloidsAndSongs solution;

    @Before
    public void setUp() {
        solution = new VocaloidsAndSongs();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int S = 3;
        int gumi = 1;
        int ia = 1;
        int mayu = 1;

        int expected = 6;
        int actual = solution.count(S, gumi, ia, mayu);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 200000000)
    public void testCase1() {
        int S = 3;
        int gumi = 3;
        int ia = 1;
        int mayu = 1;

        int expected = 9;
        int actual = solution.count(S, gumi, ia, mayu);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int S = 50;
        int gumi = 10;
        int ia = 10;
        int mayu = 10;

        int expected = 0;
        int actual = solution.count(S, gumi, ia, mayu);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int S = 18;
        int gumi = 12;
        int ia = 8;
        int mayu = 9;

        int expected = 81451692;
        int actual = solution.count(S, gumi, ia, mayu);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int S = 50;
        int gumi = 25;
        int ia = 25;
        int mayu = 25;

        int expected = 198591037;
        int actual = solution.count(S, gumi, ia, mayu);

        Assert.assertEquals(expected, actual);
    }

}
