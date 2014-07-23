package srm628.division2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BracketExpressionsTest {

    protected BracketExpressions solution;

    @Before
    public void setUp() {
        solution = new BracketExpressions();
    }

    @Test(timeout = 200000)
    public void testCase0() {
        String expression = "([]{})";

        String expected = "possible";
        String actual = solution.ifPossible(expression);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String expression = "(())[]";

        String expected = "possible";
        String actual = solution.ifPossible(expression);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String expression = "({])";

        String expected = "impossible";
        String actual = solution.ifPossible(expression);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String expression = "[]X";

        String expected = "impossible";
        String actual = solution.ifPossible(expression);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String expression = "([]X()[()]XX}[])X{{}}]";

        String expected = "possible";
        String actual = solution.ifPossible(expression);

        Assert.assertEquals(expected, actual);
    }

}
