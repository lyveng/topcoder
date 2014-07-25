package tccc04.onlineround1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlowerGardenTest {

    protected FlowerGarden solution;

    @Before
    public void setUp() {
        solution = new FlowerGarden();
    }

    @Test(timeout = 20000000)
    public void testCase0() {
        int[] height = new int[]{5, 4, 3, 2, 1};
        int[] bloom = new int[]{1, 1, 1, 1, 1};
        int[] wilt = new int[]{365, 365, 365, 365, 365};

        int[] expected = new int[]{1, 2, 3, 4, 5};
        int[] actual = solution.getOrdering(height, bloom, wilt);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 20000000)
    public void testCase1() {
        int[] height = new int[]{5, 4, 3, 2, 1};
        int[] bloom = new int[]{1, 5, 10, 15, 20};
        int[] wilt = new int[]{4, 9, 14, 19, 24};

        int[] expected = new int[]{5, 4, 3, 2, 1};
        int[] actual = solution.getOrdering(height, bloom, wilt);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] height = new int[]{5, 4, 3, 2, 1};
        int[] bloom = new int[]{1, 5, 10, 15, 20};
        int[] wilt = new int[]{5, 10, 15, 20, 25};

        int[] expected = new int[]{1, 2, 3, 4, 5};
        int[] actual = solution.getOrdering(height, bloom, wilt);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] height = new int[]{5, 4, 3, 2, 1};
        int[] bloom = new int[]{1, 5, 10, 15, 20};
        int[] wilt = new int[]{5, 10, 14, 20, 25};

        int[] expected = new int[]{3, 4, 5, 1, 2};
        int[] actual = solution.getOrdering(height, bloom, wilt);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] height = new int[]{1, 2, 3, 4, 5, 6};
        int[] bloom = new int[]{1, 3, 1, 3, 1, 3};
        int[] wilt = new int[]{2, 4, 2, 4, 2, 4};

        int[] expected = new int[]{2, 4, 6, 1, 3, 5};
        int[] actual = solution.getOrdering(height, bloom, wilt);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 20000000)
    public void testCase5() {
        int[] height = new int[]{3, 2, 5, 4};
        int[] bloom = new int[]{1, 2, 11, 10};
        int[] wilt = new int[]{4, 3, 12, 13};

        int[] expected = new int[]{4, 5, 2, 3};
        int[] actual = solution.getOrdering(height, bloom, wilt);

        Assert.assertArrayEquals(expected, actual);
    }

}
