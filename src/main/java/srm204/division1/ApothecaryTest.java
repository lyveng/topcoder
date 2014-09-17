package srm204.division1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ApothecaryTest {

    protected Apothecary solution;

    @Before
    public void setUp() {
        solution = new Apothecary();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int W = 17;

        int[] expected = new int[]{-9, -1, 27};
        int[] actual = solution.balance(W);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int W = 1;

        int[] expected = new int[]{1};
        int[] actual = solution.balance(W);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int W = 2016;

        int[] expected = new int[]{-243, -9, 81, 2187};
        int[] actual = solution.balance(W);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int W = 1000000;

        int[] expected = new int[]{-531441, -59049, -6561, -243, -27, 1, 81, 729, 2187, 1594323};
        int[] actual = solution.balance(W);

        Assert.assertArrayEquals(expected, actual);
    }

}
