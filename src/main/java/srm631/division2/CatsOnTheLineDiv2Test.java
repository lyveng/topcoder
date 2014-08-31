package srm631.division2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CatsOnTheLineDiv2Test {

    protected CatsOnTheLineDiv2 solution;

    @Before
    public void setUp() {
        solution = new CatsOnTheLineDiv2();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] position = new int[]{0};
        int[] count = new int[]{7};
        int time = 3;

        String expected = "Possible";
        String actual = solution.getAnswer(position, count, time);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] position = new int[]{0};
        int[] count = new int[]{8};
        int time = 2;

        String expected = "Impossible";
        String actual = solution.getAnswer(position, count, time);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] position = new int[]{0, 1};
        int[] count = new int[]{3, 1};
        int time = 0;

        String expected = "Impossible";
        String actual = solution.getAnswer(position, count, time);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 20000000)
    public void testCase3() {
        int[] position = new int[]{5, 0, 2};
        int[] count = new int[]{2, 3, 5};
        int time = 2;

        String expected = "Impossible";
        String actual = solution.getAnswer(position, count, time);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] position = new int[]{5, 1, -10, 7, 12, 2, 10, 20};
        int[] count = new int[]{3, 4, 2, 7, 1, 4, 3, 4};
        int time = 6;

        String expected = "Possible";
        String actual = solution.getAnswer(position, count, time);

        Assert.assertEquals(expected, actual);
    }

}
