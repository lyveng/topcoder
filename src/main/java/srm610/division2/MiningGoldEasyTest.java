package srm610.division2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MiningGoldEasyTest {

    protected MiningGoldEasy solution;

    @Before
    public void setUp() {
        solution = new MiningGoldEasy();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int N = 2;
        int M = 2;
        int[] event_i = new int[]{0};
        int[] event_j = new int[]{0};

        int expected = 4;
        int actual = solution.GetMaximumGold(N, M, event_i, event_j);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int N = 2;
        int M = 2;
        int[] event_i = new int[]{0, 2};
        int[] event_j = new int[]{0, 1};

        int expected = 7;
        int actual = solution.GetMaximumGold(N, M, event_i, event_j);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int N = 3;
        int M = 3;
        int[] event_i = new int[]{0, 3, 3};
        int[] event_j = new int[]{0, 3, 0};

        int expected = 15;
        int actual = solution.GetMaximumGold(N, M, event_i, event_j);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int N = 3;
        int M = 4;
        int[] event_i = new int[]{0, 3};
        int[] event_j = new int[]{4, 1};

        int expected = 11;
        int actual = solution.GetMaximumGold(N, M, event_i, event_j);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int N = 5;
        int M = 6;
        int[] event_i = new int[]{0, 4, 2, 5, 0};
        int[] event_j = new int[]{3, 4, 5, 6, 0};

        int expected = 48;
        int actual = solution.GetMaximumGold(N, M, event_i, event_j);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int N = 557;
        int M = 919;
        int[] event_i = new int[]{81, 509, 428, 6, 448, 149, 77, 142, 40, 405, 109, 247};
        int[] event_j = new int[]{653, 887, 770, 477, 53, 637, 201, 863, 576, 393, 512, 243};

        int expected = 16255;
        int actual = solution.GetMaximumGold(N, M, event_i, event_j);

        Assert.assertEquals(expected, actual);
    }

}
