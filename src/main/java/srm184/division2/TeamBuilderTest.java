package srm184.division2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TeamBuilderTest {

    protected TeamBuilder solution;

    @Before
    public void setUp() {
        solution = new TeamBuilder();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] paths = new String[]{"010", "000", "110"};

        int[] expected = new int[]{1, 1};
        int[] actual = solution.specialLocations(paths);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] paths = new String[]{"0010", "1000", "1100", "1000"};

        int[] expected = new int[]{1, 3};
        int[] actual = solution.specialLocations(paths);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] paths = new String[]{"01000", "00100", "00010", "00001", "10000"};

        int[] expected = new int[]{5, 5};
        int[] actual = solution.specialLocations(paths);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] paths = new String[]{"0110000", "1000100", "0000001", "0010000", "0110000", "1000010", "0001000"};

        int[] expected = new int[]{1, 3};
        int[] actual = solution.specialLocations(paths);

        Assert.assertArrayEquals(expected, actual);
    }

}
