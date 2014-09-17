package srm631.division1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CatsOnTheLineDiv1Test {

    protected CatsOnTheLineDiv1 solution;

    @Before
    public void setUp() {
        solution = new CatsOnTheLineDiv1();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] position = new int[]{0};
        int[] count = new int[]{7};
        int time = 3;

        int expected = 0;
        int actual = solution.getNumber(position, count, time);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] position = new int[]{0};
        int[] count = new int[]{6};
        int time = 2;

        int expected = 1;
        int actual = solution.getNumber(position, count, time);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] position = new int[]{4, 7, 47};
        int[] count = new int[]{4, 7, 4};
        int time = 1;

        int expected = 3;
        int actual = solution.getNumber(position, count, time);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] position = new int[]{3, 0, 7, 10};
        int[] count = new int[]{3, 7, 4, 5};
        int time = 2;

        int expected = 2;
        int actual = solution.getNumber(position, count, time);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] position = new int[]{-5, 0, 7};
        int[] count = new int[]{47, 85, 10};
        int time = 6;

        int expected = 1;
        int actual = solution.getNumber(position, count, time);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int[] position = new int[]{-8, 12, -15, -20, 17, -5, 7, 10};
        int[] count = new int[]{20, 10, 7, 9, 2, 8, 11, 10};
        int time = 2;

        int expected = 5;
        int actual = solution.getNumber(position, count, time);

        Assert.assertEquals(expected, actual);
    }

}
