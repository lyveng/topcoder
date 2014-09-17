package srm630.division1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Egalitarianism3Test {

    protected Egalitarianism3 solution;

    @Before
    public void setUp() {
        solution = new Egalitarianism3();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int n = 4;
        int[] a = new int[]{1, 1, 1};
        int[] b = new int[]{2, 3, 4};
        int[] len = new int[]{1, 1, 1};

        int expected = 3;
        int actual = solution.maxCities(n, a, b, len);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int n = 6;
        int[] a = new int[]{1, 2, 3, 2, 3};
        int[] b = new int[]{2, 3, 4, 5, 6};
        int[] len = new int[]{2, 1, 3, 2, 3};

        int expected = 3;
        int actual = solution.maxCities(n, a, b, len);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int n = 10;
        int[] a = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] b = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] len = new int[]{1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};

        int expected = 9;
        int actual = solution.maxCities(n, a, b, len);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int n = 1;
        int[] a = new int[]{};
        int[] b = new int[]{};
        int[] len = new int[]{};

        int expected = 1;
        int actual = solution.maxCities(n, a, b, len);

        Assert.assertEquals(expected, actual);
    }

}
