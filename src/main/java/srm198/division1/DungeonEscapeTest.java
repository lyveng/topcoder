package srm198.division1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DungeonEscapeTest {

    protected DungeonEscape solution;

    @Before
    public void setUp() {
        solution = new DungeonEscape();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] up = new String[]{"0x4", "0x3", "0x3"};
        String[] down = new String[]{"0x9", "009", "0x9"};
        String[] east = new String[]{"0x9", "1x9", "009"};
        String[] west = new String[]{"0x9", "0x0", "009"};
        int startLevel = 2;
        int startEasting = 2;

        int expected = 10;
        int actual = solution.exitTime(up, down, east, west, startLevel, startEasting);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] up = new String[]{"xxxxxxxxx1", "1xxxxxxxxx", "xxxxxxxxx1"};
        String[] down = new String[]{"xxxxxxxxxx", "xxxxxxxxxx", "xxxxxxxxxx"};
        String[] east = new String[]{"1111111111", "xxxxxxxxxx", "1111111111"};
        String[] west = new String[]{"xxxxxxxxxx", "1111111111", "xxxxxxxxxx"};
        int startLevel = 2;
        int startEasting = 0;

        int expected = 30;
        int actual = solution.exitTime(up, down, east, west, startLevel, startEasting);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] up = new String[]{"xxxxxxxxx1", "xxxx999991", "x999999991"};
        String[] down = new String[]{"1111111111", "1111111111", "1111111111"};
        String[] east = new String[]{"1111122242", "2222222241", "2111111111"};
        String[] west = new String[]{"xxxxxxxxx1", "1111111111", "xxxxxxxxx1"};
        int startLevel = 2;
        int startEasting = 0;

        int expected = -1;
        int actual = solution.exitTime(up, down, east, west, startLevel, startEasting);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] up = new String[]{"1x2x3x4x5x6x7x8x9", "00000000000000000", "98765432223456789", "12345678987654321"};
        String[] down = new String[]{"00000000000000000", "00000000000000000", "00000000000000000", "00000000000000000"};
        String[] east = new String[]{"xxxxxxxxxxxxxxxxx", "xxxxxxxxxxxxxxxxx", "22222222222222222", "33333333333333333"};
        String[] west = new String[]{"xxxxxxxxxxxxxxxxx", "xxxxxxxxxxxxxxxxx", "22222222222222222", "33333333333333333"};
        int startLevel = 3;
        int startEasting = 12;

        int expected = 17;
        int actual = solution.exitTime(up, down, east, west, startLevel, startEasting);

        Assert.assertEquals(expected, actual);
    }

}
