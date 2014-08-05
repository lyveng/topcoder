package srm615.division2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeStringsTest {

    protected MergeStrings solution;

    @Before
    public void setUp() {
        solution = new MergeStrings();
    }

    @Test(timeout = 20000000)
    public void testCase0() {
        String S = "??CC??";
        String A = "ABC";
        String B = "BCC";

        String expected = "ABCCBC";
        String actual = solution.getmin(S, A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String S = "WHAT?";
        String A = "THE";
        String B = "WA";

        String expected = "";
        String actual = solution.getmin(S, A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String S = "PARROT";
        String A = "PARROT";
        String B = "";

        String expected = "PARROT";
        String actual = solution.getmin(S, A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 20000000)
    public void testCase3() {
        String S = "???????????";
        String A = "AZZAA";
        String B = "AZAZZA";

        String expected = "AAZAZZAAZZA";
        String actual = solution.getmin(S, A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String S = "????K??????????????D???K???K????????K?????K???????";
        String A = "KKKKKDKKKDKKDDKDDDKDKK";
        String B = "KDKDDKKKDDKDDKKKDKDKKDDDDDDD";

        String expected = "KDKDKDKKKDDKDDKKKDKDKKDKDDDKDDDKKDKKKDKKDDKDDDKDKK";
        String actual = solution.getmin(S, A, B);

        Assert.assertEquals(expected, actual);
    }

}
