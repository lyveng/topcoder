import org.junit.Test;
import static org.junit.Assert.*;

public class FilipTheFrogTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] positions = new int[] {4, 7, 1, 3, 5};
		int L = 1;
		assertEquals(3, new FilipTheFrog().countReachableIslands(positions, L));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] positions = new int[] {100, 101, 103, 105, 107};
		int L = 2;
		assertEquals(5, new FilipTheFrog().countReachableIslands(positions, L));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] positions = new int[] {17, 10, 22, 14, 6, 1, 2, 3};
		int L = 4;
		assertEquals(7, new FilipTheFrog().countReachableIslands(positions, L));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] positions = new int[] {0};
		int L = 1000;
		assertEquals(1, new FilipTheFrog().countReachableIslands(positions, L));
	}
}
