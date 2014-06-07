package srm219.round1.division1.level2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: emmanuel
 * Date: 11/2/13
 * Time: 8:30 PM
 */
public class TurntableServiceTest {
    @Test
    public void testCalculateTime0() throws Exception {
        TurntableService t = new TurntableService();
        String[] input = new String[]{"0 2", "1", "0 1"};
        int expected = 32;
        int actual = t.calculateTime(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateTime1() throws Exception {
        TurntableService t = new TurntableService();
        String[] input = new String[]{"0", "0", "0"};
        int expected = 49;
        int actual = t.calculateTime(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateTime2() throws Exception {
        TurntableService t = new TurntableService();
        String[] input = new String[]{"4", "1", "2", "3", "0"};
        int expected = 50;
        int actual = t.calculateTime(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateTime3() throws Exception {
        TurntableService t = new TurntableService();
        String[] input = new String[]{"0 004", "2 3", "0 01", "1 2 3 4", "1 1"};
        int expected = 35;
        int actual = t.calculateTime(input);
        Assert.assertEquals(expected, actual);
    }
}
