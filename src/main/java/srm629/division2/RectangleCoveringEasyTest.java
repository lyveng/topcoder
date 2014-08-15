package srm629.division2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RectangleCoveringEasyTest {

    protected RectangleCoveringEasy solution;

    @Before
    public void setUp() {
        solution = new RectangleCoveringEasy();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int holeH = 1;
        int holeW = 1;
        int boardH = 1;
        int boardW = 1;

        int expected = -1;
        int actual = solution.solve(holeH, holeW, boardH, boardW);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int holeH = 3;
        int holeW = 5;
        int boardH = 4;
        int boardW = 6;

        int expected = 1;
        int actual = solution.solve(holeH, holeW, boardH, boardW);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int holeH = 10;
        int holeW = 20;
        int boardH = 25;
        int boardW = 15;

        int expected = 1;
        int actual = solution.solve(holeH, holeW, boardH, boardW);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int holeH = 3;
        int holeW = 10;
        int boardH = 3;
        int boardW = 12;

        int expected = 1;
        int actual = solution.solve(holeH, holeW, boardH, boardW);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000000)
    public void testCase4() {
        int holeH = 602841311;
        int holeW = 910449437;
        int boardH = 3919002;
        int boardW = 932964157;

        int expected = -1;
        int actual = solution.solve(holeH, holeW, boardH, boardW);

        Assert.assertEquals(expected, actual);
    }
}
