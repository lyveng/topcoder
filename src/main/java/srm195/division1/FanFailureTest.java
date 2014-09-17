package srm195.division1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FanFailureTest {

    protected FanFailure solution;

    @Before
    public void setUp() {
        solution = new FanFailure();
    }

    @Test(timeout = 20000000)
    public void testCase0() {
        int[] capacities = new int[]{1, 2, 3};
        int minCooling = 2;

        int[] expected = new int[]{2, 1};
        int[] actual = solution.getRange(capacities, minCooling);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] capacities = new int[]{8, 5, 6, 7};
        int minCooling = 22;

        int[] expected = new int[]{0, 0};
        int[] actual = solution.getRange(capacities, minCooling);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] capacities = new int[]{676, 11, 223, 413, 823, 122, 547, 187, 28};
        int minCooling = 1000;

        int[] expected = new int[]{7, 2};
        int[] actual = solution.getRange(capacities, minCooling);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 20000000)
    public void testCase3() {
        int[] capacities = new int[]{955, 96, 161, 259, 642, 242, 772, 369, 311, 785, 92, 991, 620, 394, 128, 774, 973, 94, 681, 771, 916, 373, 523, 100, 220, 993, 472, 798, 132, 361, 33, 362, 573, 624, 722, 520, 451, 231, 37, 921, 408, 170, 303, 559, 866, 412, 339, 757, 822, 192};
        int minCooling = 3619;

        int[] expected = new int[]{46, 30};
        int[] actual = solution.getRange(capacities, minCooling);

        Assert.assertArrayEquals(expected, actual);
    }

}
