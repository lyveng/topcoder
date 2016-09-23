import org.junit.Test;
import static org.junit.Assert.*;

public class FarmvilleDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		int[] time = new int[] {100};
		int[] cost = new int[] {1};
		int budget = 26;
		assertEquals(74, new FarmvilleDiv2().minTime(time, cost, budget));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] time = new int[] {100};
		int[] cost = new int[] {1};
		int budget = 101;
		assertEquals(0, new FarmvilleDiv2().minTime(time, cost, budget));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] time = new int[] {2,1};
		int[] cost = new int[] {1,1};
		int budget = 3;
		assertEquals(0, new FarmvilleDiv2().minTime(time, cost, budget));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] time = new int[] {1,2,3,4,5};
		int[] cost = new int[] {5,4,3,2,1};
		int budget = 15;
		assertEquals(6, new FarmvilleDiv2().minTime(time, cost, budget));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] time = new int[] {100,100,100,100,100,100,100,100,100,100};
		int[] cost = new int[] {2,4,6,8,10,1,3,5,7,9};
		int budget = 5000;
		assertEquals(50, new FarmvilleDiv2().minTime(time, cost, budget));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] time = new int[] {30,40,20,10};
		int[] cost = new int[] {10,20,30,40};
		int budget = 5;
		assertEquals(100, new FarmvilleDiv2().minTime(time, cost, budget));
	}
}
