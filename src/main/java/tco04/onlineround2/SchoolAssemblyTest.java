package tco04.onlineround2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SchoolAssemblyTest {

    protected SchoolAssembly solution;

    @Before
    public void setUp() {
        solution = new SchoolAssembly();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int kids = 1;
        int quantity = 5;

        int expected = 2;
        int actual = solution.getBeans(kids, quantity);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int kids = 1;
        int quantity = 2;

        int expected = 1;
        int actual = solution.getBeans(kids, quantity);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int kids = 5;
        int quantity = 5;

        int expected = 3;
        int actual = solution.getBeans(kids, quantity);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int kids = 223;
        int quantity = 15;

        int expected = 171;
        int actual = solution.getBeans(kids, quantity);

        Assert.assertEquals(expected, actual);
    }

}
