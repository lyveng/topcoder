package srm150.division1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StripePainterTest {

    protected StripePainter solution;

    @Before
    public void setUp() {
        solution = new StripePainter();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String stripes = "RGBGR";

        int expected = 3;
        int actual = solution.minStrokes(stripes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String stripes = "RGRG";

        int expected = 3;
        int actual = solution.minStrokes(stripes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String stripes = "ABACADA";

        int expected = 4;
        int actual = solution.minStrokes(stripes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String stripes = "AABBCCDDCCBBAABBCCDD";

        int expected = 7;
        int actual = solution.minStrokes(stripes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String stripes = "BECBBDDEEBABDCADEAAEABCACBDBEECDEDEACACCBEDABEDADD";

        int expected = 26;
        int actual = solution.minStrokes(stripes);

        Assert.assertEquals(expected, actual);
    }

}
