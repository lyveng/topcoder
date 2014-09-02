package tccc03.regional.quarterfinals;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MarketingTest {

    protected Marketing solution;

    @Before
    public void setUp() {
        solution = new Marketing();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] compete = new String[]{"1 4", "2", "3", "0", ""};

        long expected = 2L;
        long actual = solution.howMany(compete);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] compete = new String[]{"1", "2", "0"};

        long expected = -1L;
        long actual = solution.howMany(compete);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] compete = new String[]{"1", "2", "3", "0", "0 5", "1"};

        long expected = 2L;
        long actual = solution.howMany(compete);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] compete = new String[]{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

        long expected = 1073741824L;
        long actual = solution.howMany(compete);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] compete = new String[]{"1", "2", "3", "0", "5", "6", "4"};

        long expected = -1L;
        long actual = solution.howMany(compete);

        Assert.assertEquals(expected, actual);
    }

}
