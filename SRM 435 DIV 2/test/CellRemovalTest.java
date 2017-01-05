import org.junit.Test;
import static org.junit.Assert.*;

public class CellRemovalTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] parent = new int[] {-1,0,0,1,1};
		int deletedCell = 2;
		assertEquals(2, new CellRemoval().cellsLeft(parent, deletedCell));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] parent = new int[] {-1,0,0,1,1};
		int deletedCell = 1;
		assertEquals(1, new CellRemoval().cellsLeft(parent, deletedCell));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] parent = new int[] {-1,0,0,1,1};
		int deletedCell = 0;
		assertEquals(0, new CellRemoval().cellsLeft(parent, deletedCell));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] parent = new int[] {-1,0,0,2,2,4,4,6,6};
		int deletedCell = 4;
		assertEquals(2, new CellRemoval().cellsLeft(parent, deletedCell));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] parent = new int[] {26,2,32,36,40,19,43,24,30,13,21,14,24,21,19,4,30,10,44,12,7,32,17,43,
 35,18,7,36,10,16,5,38,35,4,13,-1,16,26,1,12,2,5,18,40,1,17,38,44,14};
		int deletedCell = 24;
		assertEquals(14, new CellRemoval().cellsLeft(parent, deletedCell));
	}
}
