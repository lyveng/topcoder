package srm627.division2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BubbleSortWithReversalsTest {

    protected BubbleSortWithReversals solution;

    @Before
    public void setUp() {
        solution = new BubbleSortWithReversals();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] A = new int[]{6, 8, 8, 7, 7};
        int K = 1;

        int expected = 0;
        int actual = solution.getMinSwaps(A, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] A = new int[]{7, 2, 2, 13, 5, 5, 2};
        int K = 2;

        int expected = 3;
        int actual = solution.getMinSwaps(A, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] A = new int[]{12, 5, 1, 10, 12, 6, 6, 10, 6, 8};
        int K = 2;

        int expected = 12;
        int actual = solution.getMinSwaps(A, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] A = new int[]{2, 3, 1};
        int K = 2;

        int expected = 1;
        int actual = solution.getMinSwaps(A, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] A = new int[]{482, 619, 619, 601, 660, 660, 691, 691, 77, 77, 96, 77};
        int K = 9;

        int expected = 22;
        int actual = solution.getMinSwaps(A, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 20000000)
    public void testCase5() {
        int[] A = new int[]{2,1,10,26,24};
        int K = 2;

        int expected = 0;
        int actual = solution.getMinSwaps(A, K);

        Assert.assertEquals(expected, actual);
    }
}
