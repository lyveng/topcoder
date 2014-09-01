package srm181.division1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KiloManXTest {

    protected KiloManX solution;

    @Before
    public void setUp() {
        solution = new KiloManX();
    }

    @Test(timeout = 20000000)
    public void testCase0() {
        String[] damageChart = new String[]{"070", "500", "140"};
        int[] bossHealth = new int[]{150, 150, 150};

        int expected = 218;
        int actual = solution.leastShots(damageChart, bossHealth);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] damageChart = new String[]{"1542", "7935", "1139", "8882"};
        int[] bossHealth = new int[]{150, 150, 150, 150};

        int expected = 205;
        int actual = solution.leastShots(damageChart, bossHealth);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] damageChart = new String[]{"07", "40"};
        int[] bossHealth = new int[]{150, 10};

        int expected = 48;
        int actual = solution.leastShots(damageChart, bossHealth);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] damageChart = new String[]{"198573618294842", "159819849819205", "698849290010992", "000000000000000", "139581938009384", "158919111891911", "182731827381787", "135788359198718", "187587819218927", "185783759199192", "857819038188122", "897387187472737", "159938981818247", "128974182773177", "135885818282838"};
        int[] bossHealth = new int[]{157, 1984, 577, 3001, 2003, 2984, 5988, 190003, 9000, 102930, 5938, 1000000, 1000000, 5892, 38};

        int expected = 260445;
        int actual = solution.leastShots(damageChart, bossHealth);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] damageChart = new String[]{"02111111", "10711111", "11071111", "11104111", "41110111", "11111031", "11111107", "11111210"};
        int[] bossHealth = new int[]{28, 28, 28, 28, 28, 28, 28, 28};

        int expected = 92;
        int actual = solution.leastShots(damageChart, bossHealth);

        Assert.assertEquals(expected, actual);
    }

}
