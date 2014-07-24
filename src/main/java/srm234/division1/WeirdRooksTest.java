package srm234.division1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WeirdRooksTest {

    protected WeirdRooks solution;

    @Before
    public void setUp() {
        solution = new WeirdRooks();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] cols = new int[]{3, 3, 3};

        String expected = "0,9 1,4 1,5 1,6 1,7 1,8 2,1 2,2 2,3 2,4 2,5 2,6 3,0 3,1 3,2 3,3";
        String actual = solution.describe(cols);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 200000000)
    public void testCase1() {
        int[] cols = new int[]{1, 2, 3};

        String expected = "0,6 1,3 1,4 1,5 2,1 2,2 2,3 3,0";
        String actual = solution.describe(cols);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] cols = new int[]{1};

        String expected = "0,1 1,0";
        String actual = solution.describe(cols);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] cols = new int[]{2, 9};

        String expected = "0,11 1,2 1,3 1,4 1,5 1,6 1,7 1,8 1,9 1,10 2,0 2,1 2,2 2,3 2,4 2,5 2,6 2,7 2,8";
        String actual = solution.describe(cols);

        Assert.assertEquals(expected, actual);
    }

}
