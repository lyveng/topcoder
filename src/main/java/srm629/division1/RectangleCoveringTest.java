package srm629.division1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RectangleCoveringTest {

    protected RectangleCovering solution;

    @Before
    public void setUp() {
        solution = new RectangleCovering();
    }

    @Test(timeout = 20000000)
    public void testCase0() {
        int holeH = 5;
        int holeW = 5;
        int[] boardH = new int[]{8, 8, 8};
        int[] boardW = new int[]{2, 3, 4};

        int expected = 2;
        int actual = solution.minimumNumber(holeH, holeW, boardH, boardW);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int holeH = 10;
        int holeW = 10;
        int[] boardH = new int[]{6, 6, 6, 6};
        int[] boardW = new int[]{6, 6, 6, 6};

        int expected = -1;
        int actual = solution.minimumNumber(holeH, holeW, boardH, boardW);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int holeH = 5;
        int holeW = 5;
        int[] boardH = new int[]{5};
        int[] boardW = new int[]{5};

        int expected = -1;
        int actual = solution.minimumNumber(holeH, holeW, boardH, boardW);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int holeH = 3;
        int holeW = 5;
        int[] boardH = new int[]{6};
        int[] boardW = new int[]{4};

        int expected = 1;
        int actual = solution.minimumNumber(holeH, holeW, boardH, boardW);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int holeH = 10000;
        int holeW = 5000;
        int[] boardH = new int[]{12345, 12343, 12323, 12424, 1515, 6666, 6789, 1424, 11111, 25};
        int[] boardW = new int[]{1442, 2448, 42, 1818, 3535, 3333, 3456, 7890, 1, 52};

        int expected = 3;
        int actual = solution.minimumNumber(holeH, holeW, boardH, boardW);

        Assert.assertEquals(expected, actual);
    }

}
