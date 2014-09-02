package srm242.division1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DiceThrowsTest {

    protected DiceThrows solution;

    @Before
    public void setUp() {
        solution = new DiceThrows();
    }

    public static void assertEquals(double expected, double actual) {
        if (Double.isNaN(expected)) {
            Assert.assertTrue("expected: <NaN> but was: <" + actual + ">", Double.isNaN(actual));
            return;
        }
        double delta = Math.max(1e-9, 1e-9 * Math.abs(expected));
        Assert.assertEquals(expected, actual, delta);
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int numDiceA = 1;
        int[] sidesA = new int[]{1, 2, 3, 4, 5, 6};
        int numDiceB = 1;
        int[] sidesB = new int[]{1, 2, 3, 4, 5, 6};

        double expected = 0.41666666666666663;
        double actual = solution.winProbability(numDiceA, sidesA, numDiceB, sidesB);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int numDiceA = 200;
        int[] sidesA = new int[]{1, 3, 8, 18, 45, 100};
        int numDiceB = 200;
        int[] sidesB = new int[]{1, 4, 10, 21, 53, 100};

        double expected = 0.25240407058279035;
        double actual = solution.winProbability(numDiceA, sidesA, numDiceB, sidesB);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int numDiceA = 2;
        int[] sidesA = new int[]{1, 1, 1, 2, 2, 2};
        int numDiceB = 3;
        int[] sidesB = new int[]{1, 1, 1, 1, 1, 1};

        double expected = 0.25;
        double actual = solution.winProbability(numDiceA, sidesA, numDiceB, sidesB);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int numDiceA = 200;
        int[] sidesA = new int[]{6, 5, 4, 3, 2, 1};
        int numDiceB = 200;
        int[] sidesB = new int[]{3, 4, 6, 5, 1, 2};

        double expected = 0.49416239842107595;
        double actual = solution.winProbability(numDiceA, sidesA, numDiceB, sidesB);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int numDiceA = 100;
        int[] sidesA = new int[]{1, 1, 1, 1, 1, 2};
        int numDiceB = 199;
        int[] sidesB = new int[]{1, 1, 1, 1, 1, 1};

        double expected = 1.5306467074865068E-78;
        double actual = solution.winProbability(numDiceA, sidesA, numDiceB, sidesB);

        assertEquals(expected, actual);
    }

}
