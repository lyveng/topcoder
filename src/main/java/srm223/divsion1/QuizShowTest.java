package srm223.divsion1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuizShowTest {

    protected QuizShow solution;

    @Before
    public void setUp() {
        solution = new QuizShow();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] scores = new int[]{100, 100, 100};
        int wager1 = 25;
        int wager2 = 75;

        int expected = 76;
        int actual = solution.wager(scores, wager1, wager2);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] scores = new int[]{10, 50, 60};
        int wager1 = 30;
        int wager2 = 41;

        int expected = 0;
        int actual = solution.wager(scores, wager1, wager2);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] scores = new int[]{10, 50, 60};
        int wager1 = 31;
        int wager2 = 41;

        int expected = 10;
        int actual = solution.wager(scores, wager1, wager2);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] scores = new int[]{2, 2, 12};
        int wager1 = 0;
        int wager2 = 10;

        int expected = 1;
        int actual = solution.wager(scores, wager1, wager2);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] scores = new int[]{10000, 10000, 10000};
        int wager1 = 9998;
        int wager2 = 9997;

        int expected = 9999;
        int actual = solution.wager(scores, wager1, wager2);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int[] scores = new int[]{5824, 4952, 6230};
        int wager1 = 364;
        int wager2 = 287;

        int expected = 694;
        int actual = solution.wager(scores, wager1, wager2);

        Assert.assertEquals(expected, actual);
    }

}
