import org.junit.Test;
import static org.junit.Assert.*;

public class WalkOverATreeTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] parent = new int[] {0, 0};
		int L = 2;
		assertEquals(2, new WalkOverATree().maxNodesVisited(parent, L));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] parent = new int[] {0, 0};
		int L = 3;
		assertEquals(3, new WalkOverATree().maxNodesVisited(parent, L));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] parent = new int[] {0, 1, 2, 3};
		int L = 2;
		assertEquals(3, new WalkOverATree().maxNodesVisited(parent, L));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] parent = new int[] {0,0,0,0,2,4,2,3,1};
		int L = 1;
		assertEquals(2, new WalkOverATree().maxNodesVisited(parent, L));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] parent = new int[] {0,0,1,2,3,2,3,1,3,0,1,8,6,8,0,5,15,0,9};
		int L = 4;
		assertEquals(5, new WalkOverATree().maxNodesVisited(parent, L));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] parent = new int[] {0,0,0,1,1,3,5,1,4,5,2,2,10,5,10,10,11,13,8,3,18,15,20,20,23,8,11,26,4};
		int L = 26;
		assertEquals(17, new WalkOverATree().maxNodesVisited(parent, L));
	}
	
	@Test(timeout=2000)
	public void test6() {
		int[] parent = new int[] {0, 0, 2, 0}
;
		int L = 100;
		assertEquals(5, new WalkOverATree().maxNodesVisited(parent, L));
	}
	
	@Test(timeout=2000)
	public void test7() {
		int[] parent = new int[] {0, 0, 2};
		int L = 4;
		assertEquals(4, new WalkOverATree().maxNodesVisited(parent, L));
	}
}
