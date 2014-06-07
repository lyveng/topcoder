package srm223.round1.divsion1.level3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: emmanuel
 * Date: 10/23/13
 * Time: 1:57 AM
 */
public class RevolvingDoorsTest {
    RevolvingDoors r;

    @Before
    public void setUp() throws Exception {
        r = new RevolvingDoors();
    }

    @Test
    public void testTurns0() throws Exception {
        String[] map = new String[]{"    ### ",
                "    #E# ",
                "   ## # ",
                "####  ##",
                "# S -O-#",
                "# ###  #",
                "#      #",
                "########"};
        Assert.assertEquals(2, r.turns(map));
    }

    @Test
    public void testTurns1() throws Exception {
        String[] map = new String[]{"#### ",
                "#S|##",
                "# O #",
                "##|E#",
                " ####"};
        Assert.assertEquals(-1, r.turns(map));
    }

    @Test
    public void testTurns3() throws Exception {
        String[] map = new String[]{"###########",
                "#    #    #",
                "#  S | E  #",
                "#    O    #",
                "#    |    #",
                "#         #",
                "###########"};
        Assert.assertEquals(0, r.turns(map));
    }

    @Test
    public void testTurns4() throws Exception {
        String[] map = new String[]{"        E",
                "    |    ",
                "    O    ",
                "    |    ",
                " -O-S-O- ",
                "    |    ",
                "    O    ",
                "    |    ",
                "         "};
        Assert.assertEquals(-1, r.turns(map));
    }

    @Test
    public void testTurns2() throws Exception {
        String[] map = new String[]{" |  |  |     |  |  |  |  |  | ",
                " O  O EO -O- O  O  O  O  OS O ",
                " |  |  |     |  |  |  |  |  | "};
        Assert.assertEquals(7, r.turns(map));
    }

    @Test
    public void testTurns5() throws Exception {
        String[] map = new String[]{"##E#   ",
                "#  ##  ",
                " -O-## ",
                " #  ## ",
                " ##  ##",
                "  -O-  ",
                "##  ## ",
                " # ### ",
                " #  S  "};
        Assert.assertEquals(5, r.turns(map));
    }

    @Test
    public void testTurns6() throws Exception {
        String[] map = new String[]{"#############",
                "#  #|##|#   #",
                "#   O  O    #",
                "# E || || S #",
                "#    O  O   #",
                "#   #|##|#  #",
                "#############"};
        Assert.assertEquals(4, r.turns(map));
    }
}
