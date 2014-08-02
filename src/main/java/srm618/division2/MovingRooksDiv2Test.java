package srm618.division2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MovingRooksDiv2Test {

    protected MovingRooksDiv2 solution;

    @Before
    public void setUp() {
        solution = new MovingRooksDiv2();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] Y1 = new int[]{0};
        int[] Y2 = new int[]{0};

        String expected = "Possible";
        String actual = solution.move(Y1, Y2);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 200000000)
    public void testCase1() {
        int[] Y1 = new int[]{1, 0};
        int[] Y2 = new int[]{0, 1};

        String expected = "Possible";
        String actual = solution.move(Y1, Y2);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] Y1 = new int[]{0, 1};
        int[] Y2 = new int[]{1, 0};

        String expected = "Impossible";
        String actual = solution.move(Y1, Y2);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] Y1 = new int[]{3, 1, 2, 0};
        int[] Y2 = new int[]{0, 2, 1, 3};

        String expected = "Possible";
        String actual = solution.move(Y1, Y2);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] Y1 = new int[]{3, 1, 2, 0};
        int[] Y2 = new int[]{3, 2, 0, 1};

        String expected = "Impossible";
        String actual = solution.move(Y1, Y2);

        Assert.assertEquals(expected, actual);
    }

}
