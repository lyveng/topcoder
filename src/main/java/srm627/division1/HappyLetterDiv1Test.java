package srm627.division1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HappyLetterDiv1Test {

    protected HappyLetterDiv1 solution;

    @Before
    public void setUp() {
        solution = new HappyLetterDiv1();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String letters = "aabbacccc";

        String expected = "abc";
        String actual = solution.getHappyLetters(letters);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String letters = "aaaaaaaccdd";

        String expected = "a";
        String actual = solution.getHappyLetters(letters);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String letters = "ddabccadb";

        String expected = "abcd";
        String actual = solution.getHappyLetters(letters);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String letters = "aaabbb";

        String expected = "";
        String actual = solution.getHappyLetters(letters);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 20000000)
    public void testCase4() {
        String letters = "rdokcogscosn";

        String expected = "cos";
        String actual = solution.getHappyLetters(letters);

        Assert.assertEquals(expected, actual);
    }

}
