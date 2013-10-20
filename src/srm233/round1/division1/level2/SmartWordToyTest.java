package srm233.round1.division1.level2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: emmanuel
 * Date: 10/8/13
 * Time: 3:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class SmartWordToyTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetNextNode() throws Exception {
        String expected = "abaa";
        String actual = SmartWordToy.getNextNode("aaaa", 1, 1);
        Assert.assertEquals("Failed for aaaa, 1, 1", expected, actual);

        expected = "aaza";
        actual = SmartWordToy.getNextNode("aaaa", 2, -1);
        Assert.assertEquals("Failed for aaaa, 2, -1", expected, actual);

        expected = "azzz";
        actual = SmartWordToy.getNextNode("zzzz", 0, 1);
        Assert.assertEquals("Failed for zzzz, 0, 1", expected, actual);
    }

    @Test
    public void testMinPresses() throws Exception {
        SmartWordToy swt = new SmartWordToy();
        int expected = 8;
        int actual = swt.minPresses("aaaa","zzzz",new String[]{"a a a z","a a z a","a z a a","z a a a","a z z z","z a z z","z z a z","z z z a"});
        Assert.assertEquals("Failed", expected, actual);
    }
}
