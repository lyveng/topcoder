package srm222.division1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GroceryBaggerTest {

    protected GroceryBagger solution;

    @Before
    public void setUp() {
        solution = new GroceryBagger();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int strength = 2;
        String[] itemType = new String[]{"DAIRY", "DAIRY", "PRODUCE", "PRODUCE", "PRODUCE", "MEAT"};

        int expected = 4;
        int actual = solution.minimumBags(strength, itemType);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int strength = 3;
        String[] itemType = new String[]{"DAIRY", "DAIRY", "PRODUCE", "PRODUCE", "PRODUCE", "MEAT"};

        int expected = 3;
        int actual = solution.minimumBags(strength, itemType);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int strength = 10;
        String[] itemType = new String[]{};

        int expected = 0;
        int actual = solution.minimumBags(strength, itemType);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int strength = 5;
        String[] itemType = new String[]{"CANNED", "CANNED", "PRODUCE", "DAIRY", "MEAT", "BREAD", "HOUSEHOLD", "PRODUCE", "FROZEN", "PRODUCE", "DAIRY"};

        int expected = 7;
        int actual = solution.minimumBags(strength, itemType);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int strength = 2;
        String[] itemType = new String[]{"CANNED", "CANNED", "PRODUCE", "DAIRY", "MEAT", "BREAD", "HOUSEHOLD", "PRODUCE", "FROZEN", "PRODUCE", "DAIRY"};

        int expected = 8;
        int actual = solution.minimumBags(strength, itemType);

        Assert.assertEquals(expected, actual);
    }

}
