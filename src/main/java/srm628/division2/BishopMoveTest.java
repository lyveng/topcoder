package srm628.division2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BishopMoveTest {

    protected BishopMove solution;

    @Before
    public void setUp() {
        solution = new BishopMove();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int r1 = 4;
        int c1 = 6;
        int r2 = 7;
        int c2 = 3;

        int expected = 1;
        int actual = solution.howManyMoves(r1, c1, r2, c2);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int r1 = 2;
        int c1 = 5;
        int r2 = 2;
        int c2 = 5;

        int expected = 0;
        int actual = solution.howManyMoves(r1, c1, r2, c2);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int r1 = 1;
        int c1 = 3;
        int r2 = 5;
        int c2 = 5;

        int expected = 2;
        int actual = solution.howManyMoves(r1, c1, r2, c2);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int r1 = 4;
        int c1 = 6;
        int r2 = 7;
        int c2 = 4;

        int expected = -1;
        int actual = solution.howManyMoves(r1, c1, r2, c2);

        Assert.assertEquals(expected, actual);
    }

}
