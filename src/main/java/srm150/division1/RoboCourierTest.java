package srm150.division1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoboCourierTest {

    protected RoboCourier solution;

    @Before
    public void setUp() {
        solution = new RoboCourier();
    }

    @Test(timeout = 20000000)
    public void testCase0() {
        String[] path = new String[]{"FRRFLLFLLFRRFLF"};

        int expected = 15;
        int actual = solution.timeToDeliver(path);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] path = new String[]{"RFLLF"};

        int expected = 17;
        int actual = solution.timeToDeliver(path);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] path = new String[]{"FLFRRFRFRRFLLFRRF"};

        int expected = 0;
        int actual = solution.timeToDeliver(path);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] path = new String[]{"FFFFFFFFFRRFFFFFFRRFFFFF", "FLLFFFFFFLLFFFFFFRRFFFF"};

        int expected = 44;
        int actual = solution.timeToDeliver(path);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] path = new String[]{"RFLLFLFLFRFRRFFFRFFRFFRRFLFFRLRRFFLFFLFLLFRFLFLRFF", "RFFLFLFFRFFLLFLLFRFRFLRLFLRRFLRFLFFLFFFLFLFFRLFRLF", "LLFLFLRLRRFLFLFRLFRF"};

        int expected = 24;
        int actual = solution.timeToDeliver(path);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 20000000)
    public void testCase5() {
        String[] path = new String[]{"LLFLFRLRRLRFFLRRRRFFFLRFFRRRLLFLFLLRLRFFLFRRFFFLFL", "RLFFRRLRLRRFFFLLLRFRLLRFFLFRLFRRFRRRFRLRLRLFFLLFLF", "FRFLRFRRLLLRFFRRRLRFLFRRFLFFRLFLFLFRLLLLFRLLRFLLLF", "FFLFRFRRFLLFFLLLFFRLLFLRRFRLFFFRRFFFLLRFFLRFRRRLLR", "FFFRRLLFLLRLFRRLRLLFFFLFLRFFRLRLLFLRLFFLLFFLLFFFRR", "LRFRRFLRRLRRLRFFFLLLLRRLRFFLFRFFRLLRFLFRRFLFLFFLFR", "RFRRLRRFLFFFLLRFLFRRFRFLRLRLLLLFLFFFLFRLLRFRLFRLFR", "LLFLFRLFFFFFFFRRLRLRLLRFLRLRRRRRRRRLFLFLFLRFLFRLFF", "RLFRRLLRRRRFFFRRRLLLLRRLFFLLLLLRFFFFRFRRLRRRFFFLLF", "FFFFLRRLRFLLRRLRLRFRRRRLFLLRFLRRFFFRFRLFFRLLFFRRLL"};

        int expected = 169;
        int actual = solution.timeToDeliver(path);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 20000000)
    public void testCase6() {
        String[] path = new String[]{"RLFRFFRFRFFRFFLFFLRLRLFLFLRFFRFLRLRFLFFLFFFRLFRLFL", "RLRFRFRFLFLFLFFLRLFFLRLRFFFLFLFFLFRLFFFFRLFFLRLFFL", "FLRFRLRLFLRLFRLFLFFFRLRLRRFLFLFFFLRFLRFFLRFLRLLFLR", "LFFRLFRFRFRLLFLRFRLLFRLFFFRLRLLFRFLFLFRLLFFLFLRLFF", "FFLFLRRFFFLRFLRFLFLFFLRFLFFLFFFLRLFFFLRFLFRFFRFFFR", "FLRLRLRRFRLRFLFLFRRFLLFRFLRFFLRLFLFLRLFFLRLRFFLFLF", "LFLFLRFFFFRFRLFRFFFFFLFLFFLRLFFFRFFFFFLFFFLFLFRFRL", "LRLFLRLRRLFRLRRLRLRLRFLFLRLRLLRFLFRFRRLFFFLFLFFLLR", "LRLFFRFLFFFLLFRFLFRLRFFLFLFRRFFFFFLRRFFRLRLFFRLRLF", "LFRLRRLRLRRLRLRFLLFLRLLFLFLFLRLRFFRLRFLRFFRFLLFRFF"};

        int expected = 143;
        int actual = solution.timeToDeliver(path);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 20000000)
    public void testCase7() {
        String[] path = new String[]{"FLRLRFLRLRFLFLRFFFFLRFLFFFLRFFRLFRLRFLRLRRFRLRFRRF", "LRFFFRRFFLFLFLFRLLFFFLFFLFLLFLFFLFFFRFFFFLRLRLFLRF", "LFRLFLFFLFLRRFLRFRLFRLLFLRFLFLRFFFLRFLFRLFLRRFFLRL", "LRFFLLFLRLRLLFFFRFFRLFRFRLRLFFFRLRFLFLFLFRLRRFLRRF", "FLFFLFLFRLRLRLFRFFLLFLFLRFFRRFLRFFLRLRLRFRLFLFLFLR", "LFLRRFLLFLFLFLFFLLFFFLFFRFRLRFLFRFRLFLRFFLFRRFFFLL", "RFFFLRLFFRLFRFLRLFRFLFRFLFRRLFFLFRLRLLFRLFLFFFLFFR", "LRLLFFRFRFRLRLRFFRLFFLLFFFLRFFRFLFRFLRLRLRLFLFLFLF", "LLFLFRFLLFFLFFLRLFRRFLRLRLRFFRLFFLRFLFFRFLFLFLFFLR", "FFFLLFRFRLLFFFLRLFLRLFRLRRFLRFLRFFRFRFLFLLRFLFLRFL"};

        int expected = 169;
        int actual = solution.timeToDeliver(path);

        Assert.assertEquals(expected, actual);
    }
}
