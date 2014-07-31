package srm197.division2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuickSumsTest {

    protected QuickSums solution;

    @Before
    public void setUp() {
        solution = new QuickSums();
    }

    @Test(timeout = 20000000)
    public void testCase0() {
        String numbers = "99999";
        int sum = 45;

        int expected = 4;
        int actual = solution.minSums(numbers, sum);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String numbers = "1110";
        int sum = 3;

        int expected = 3;
        int actual = solution.minSums(numbers, sum);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String numbers = "0123456789";
        int sum = 45;

        int expected = 8;
        int actual = solution.minSums(numbers, sum);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String numbers = "99999";
        int sum = 100;

        int expected = -1;
        int actual = solution.minSums(numbers, sum);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String numbers = "382834";
        int sum = 100;

        int expected = 2;
        int actual = solution.minSums(numbers, sum);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String numbers = "9230560001";
        int sum = 71;

        int expected = 4;
        int actual = solution.minSums(numbers, sum);

        Assert.assertEquals(expected, actual);
    }

}
