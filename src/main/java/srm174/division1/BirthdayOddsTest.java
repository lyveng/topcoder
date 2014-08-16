package srm174.division1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BirthdayOddsTest {

    protected BirthdayOdds solution;

    @Before
    public void setUp() {
        solution = new BirthdayOdds();
    }

    @Test(timeout = 20000000)
    public void testCase0() {
        int minOdds = 75;
        int daysInYear = 5;

        int expected = 4;
        int actual = solution.minPeople(minOdds, daysInYear);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int minOdds = 50;
        int daysInYear = 365;

        int expected = 23;
        int actual = solution.minPeople(minOdds, daysInYear);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int minOdds = 1;
        int daysInYear = 365;

        int expected = 4;
        int actual = solution.minPeople(minOdds, daysInYear);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int minOdds = 84;
        int daysInYear = 9227;

        int expected = 184;
        int actual = solution.minPeople(minOdds, daysInYear);

        Assert.assertEquals(expected, actual);
    }

}
