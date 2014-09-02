package srm156.division1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PathFindingTest {

    protected PathFinding solution;

    @Before
    public void setUp() {
        solution = new PathFinding();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] board = new String[]{"....", ".A..", "..B.", "...."};

        int expected = 2;
        int actual = solution.minTurns(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] board = new String[]{"XXXXXXXXX", "A...X...B", "XXXXXXXXX"};

        int expected = -1;
        int actual = solution.minTurns(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] board = new String[]{"XXXXXXXXX", "A.......B", "XXXXXXXXX"};

        int expected = -1;
        int actual = solution.minTurns(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] board = new String[]{"XXXXXXXXX", "A.......B", "XXXX.XXXX"};

        int expected = 8;
        int actual = solution.minTurns(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] board = new String[]{"...A.XXXXX.....", ".....XXXXX.....", "...............", ".....XXXXX.B...", ".....XXXXX....."};

        int expected = 13;
        int actual = solution.minTurns(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String[] board = new String[]{"AB.................X", "XXXXXXXXXXXXXXXXXXX.", "X..................X", ".XXXXXXXXXXXXXXXXXXX", "X..................X", "XXXXXXXXXXXXXXXXXXX.", "X..................X", ".XXXXXXXXXXXXXXXXXXX", "X..................X", "XXXXXXXXXXXXXXXXXXX.", "X..................X", ".XXXXXXXXXXXXXXXXXXX", "X..................X", "XXXXXXXXXXXXXXXXXXX.", "X..................X", ".XXXXXXXXXXXXXXXXXXX", "X..................X", "XXXXXXXXXXXXXXXXXXX.", "...................X", ".XXXXXXXXXXXXXXXXXXX"};

        int expected = 379;
        int actual = solution.minTurns(board);

        Assert.assertEquals(expected, actual);
    }

}
