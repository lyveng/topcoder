import org.junit.Test;
import static org.junit.Assert.*;

public class ChristmasTreeDecorationTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] col = new int[] {1,1,2,2};
		int[] x = new int[] {1,2,3,4};
		int[] y = new int[] {2,3,4,1};
		assertEquals(1, new ChristmasTreeDecoration().solve(col, x, y));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] col = new int[] {1,1,2,2};
		int[] x = new int[] {1,2,3,4,1,2};
		int[] y = new int[] {2,3,4,1,3,4};
		assertEquals(0, new ChristmasTreeDecoration().solve(col, x, y));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] col = new int[] {50,50,50,50};
		int[] x = new int[] {1,2,3,1,1,2};
		int[] y = new int[] {2,3,4,4,3,4};
		assertEquals(3, new ChristmasTreeDecoration().solve(col, x, y));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] col = new int[] {1,4,2,3};
		int[] x = new int[] {1,2,3};
		int[] y = new int[] {2,3,4};
		assertEquals(0, new ChristmasTreeDecoration().solve(col, x, y));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] col = new int[] {1,1,1,2,2,2,3,3,3,4,4,4};
		int[] x = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,1,1,1,1,1,1};
		int[] y = new int[] {2,3,1,5,6,4,8,9,7,11,12,10,5,7,12,11,6,4};
		assertEquals(5, new ChristmasTreeDecoration().solve(col, x, y));
	}
}
