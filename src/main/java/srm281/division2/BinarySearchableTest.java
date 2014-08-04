package srm281.division2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchableTest {

    protected BinarySearchable solution;

    @Before
    public void setUp() {
        solution = new BinarySearchable();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] sequence = new int[]{1, 3, 2};

        int expected = 1;
        int actual = solution.howMany(sequence);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] sequence = new int[]{3, 2, 1, 10, 23, 22, 21};

        int expected = 1;
        int actual = solution.howMany(sequence);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] sequence = new int[]{1, 5, 7, 11, 12, 18};

        int expected = 6;
        int actual = solution.howMany(sequence);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] sequence = new int[]{5, 4, 3, 2, 1, 0};

        int expected = 0;
        int actual = solution.howMany(sequence);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] sequence = new int[]{1, 3, 2, 4, 5, 7, 6, 8};

        int expected = 4;
        int actual = solution.howMany(sequence);

        Assert.assertEquals(expected, actual);
    }

}
