package tccc03.semifinals4;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CircuitsTest {

    protected Circuits solution;

    @Before
    public void setUp() {
        solution = new Circuits();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] connects = new String[]{"1 2", "2", ""};
        String[] costs = new String[]{"5 3", "7", ""};

        int expected = 12;
        int actual = solution.howLong(connects, costs);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] connects = new String[]{"1 2 3 4 5", "2 3 4 5", "3 4 5", "4 5", "5", ""};
        String[] costs = new String[]{"2 2 2 2 2", "2 2 2 2", "2 2 2", "2 2", "2", ""};

        int expected = 10;
        int actual = solution.howLong(connects, costs);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] connects = new String[]{"1", "2", "3", "", "5", "6", "7", ""};
        String[] costs = new String[]{"2", "2", "2", "", "3", "3", "3", ""};

        int expected = 9;
        int actual = solution.howLong(connects, costs);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] connects = new String[]{"", "2 3 5", "4 5", "5 6", "7", "7 8", "8 9", "10", "10 11 12", "11", "12", "12", ""};
        String[] costs = new String[]{"", "3 2 9", "2 4", "6 9", "3", "1 2", "1 2", "5", "5 6 9", "2", "5", "3", ""};

        int expected = 22;
        int actual = solution.howLong(connects, costs);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] connects = new String[]{"", "2 3", "3 4 5", "4 6", "5 6", "7", "5 7", ""};
        String[] costs = new String[]{"", "30 50", "19 6 40", "12 10", "35 23", "8", "11 20", ""};

        int expected = 105;
        int actual = solution.howLong(connects, costs);

        Assert.assertEquals(expected, actual);
    }

}
