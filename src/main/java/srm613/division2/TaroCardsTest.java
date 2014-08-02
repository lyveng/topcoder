package srm613.division2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaroCardsTest {

    protected TaroCards solution;

    @Before
    public void setUp() {
        solution = new TaroCards();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] first = new int[]{1, 2};
        int[] second = new int[]{2, 3};
        int K = 2;

        long expected = 3L;
        long actual = solution.getNumber(first, second, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] first = new int[]{3, 1, 2};
        int[] second = new int[]{1, 1, 1};
        int K = 3;

        long expected = 8L;
        long actual = solution.getNumber(first, second, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] first = new int[]{4, 2, 1, 3};
        int[] second = new int[]{1, 2, 3, 4};
        int K = 5;

        long expected = 16L;
        long actual = solution.getNumber(first, second, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] first = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] second = new int[]{2, 1, 10, 9, 3, 2, 2};
        int K = 3;

        long expected = 17L;
        long actual = solution.getNumber(first, second, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] first = new int[]{1};
        int[] second = new int[]{2};
        int K = 1;

        long expected = 1L;
        long actual = solution.getNumber(first, second, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int[] first = new int[]{6, 20, 1, 11, 19, 14, 2, 8, 15, 21, 9, 10, 4, 16, 12, 17, 13, 22, 7, 18, 3, 5};
        int[] second = new int[]{4, 5, 10, 7, 6, 2, 1, 10, 10, 7, 9, 4, 5, 9, 5, 10, 10, 3, 6, 6, 4, 4};
        int K = 14;

        long expected = 2239000L;
        long actual = solution.getNumber(first, second, K);

        Assert.assertEquals(expected, actual);
    }

}
