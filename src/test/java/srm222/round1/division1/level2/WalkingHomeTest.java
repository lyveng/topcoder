package srm222.round1.division1.level2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: emmanuel
 * Date: 10/20/13
 * Time: 10:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class WalkingHomeTest {
    @Test
    public void testFewestCrossings() throws Exception {
        WalkingHome w = new WalkingHome();
        String[] input0 = new String[] {"S.|..",
                "..|.H"};
        Assert.assertEquals(1, w.fewestCrossings(input0));
        String[] input1 = new String[] {"S.|..",
                "..|.H",
                "..|..",
                "....."};
        w.fewestCrossings(input1);
        Assert.assertEquals(0, w.fewestCrossings(input1));
        String[] input2 = new String[] {"S.||...",
                "..||...",
                "..||...",
                "..||..H"};
        Assert.assertEquals(1, w.fewestCrossings(input2));
        String[] input3 = new String[] {"S.....",
                "---*--",
                "...|..",
                "...|.H"};
        Assert.assertEquals(1, w.fewestCrossings(input3));
        String[] input4 = new String[] {"S.F..",
                "..F..",
                "--*--",
                "..|..",
                "..|.H"};
        Assert.assertEquals(2, w.fewestCrossings(input4));
        String[] input5 = new String[] {"H|.|.|.|.|.|.|.|.|.|.|.|.|.",
                "F|F|F|F|F|F|F|F|F|F|F|F|F|-",
                "S|.|.|.|.|.|.|.|.|.|.|.|.|."};
        Assert.assertEquals(27, w.fewestCrossings(input5));
        String[] input6 = new String[]{"S-H"};
        Assert.assertEquals(-1, w.fewestCrossings(input6));
    }
}
