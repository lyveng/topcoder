import org.junit.Test;
import static org.junit.Assert.*;

public class FamilyTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] parent1 = new int[] {-1,-1,0};
		int[] parent2 = new int[] {-1,-1,1};
		assertEquals("Possible", new Family().isFamily(parent1, parent2));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] parent1 = new int[] {-1,-1,-1,-1,-1};
		int[] parent2 = new int[] {-1,-1,-1,-1,-1};
		assertEquals("Possible", new Family().isFamily(parent1, parent2));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] parent1 = new int[] {-1,-1,0,0,1};
		int[] parent2 = new int[] {-1,-1,1,2,2};
		assertEquals("Impossible", new Family().isFamily(parent1, parent2));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] parent1 = new int[] {-1,-1,-1,-1,1,-1,0,5,6,-1,0,3,8,6}
;
		int[] parent2 = new int[] {-1,-1,-1,-1,3,-1,4,6,5,-1,5,4,6,1}
;
		assertEquals("Possible", new Family().isFamily(parent1, parent2));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] parent1 = new int[] {-1,-1,-1,2,2,-1,5,6,4,6,2,1,8,0,2,4,6,9,-1,16,-1,11};
		int[] parent2 = new int[] {-1,-1,-1,1,0,-1,1,4,2,0,4,8,2,3,0,5,14,14,-1,7,-1,13};
		assertEquals("Impossible", new Family().isFamily(parent1, parent2));
	}
}
