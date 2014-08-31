package srm631.division2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaroGridTest {

    protected TaroGrid solution;

    @Before
    public void setUp() {
        solution = new TaroGrid();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] grid = new String[]{"W"};

        int expected = 1;
        int actual = solution.getNumber(grid);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] grid = new String[]{"WB", "BW"};

        int expected = 1;
        int actual = solution.getNumber(grid);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000000)
    public void testCase2() {
        String[] grid = new String[]{"BWW", "BBB", "BWB"};

        int expected = 3;
        int actual = solution.getNumber(grid);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] grid = new String[]{"BWBW", "BBWB", "WWWB", "BWWW"};

        int expected = 3;
        int actual = solution.getNumber(grid);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] grid = new String[]{"BWB", "BBW", "BWB"};

        int expected = 3;
        int actual = solution.getNumber(grid);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String[] grid = new String[]{"BBWWBBWW", "BBWWBBWW", "WWBBWWBB", "WWBBWWBB", "BBWWBBWW", "BBWWBBWW", "WWBBWWBB", "WWBBWWBB"};

        int expected = 2;
        int actual = solution.getNumber(grid);

        Assert.assertEquals(expected, actual);
    }

}
