import org.junit.Test;
import static org.junit.Assert.*;

public class MultiplicationTable2EasyTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] table = new int[] {1, 1, 2, 3,
 1, 0, 2, 3,
 3, 3, 0, 3,
 2, 2, 2, 0}
;
		int[] t = new int[] {1,0};
		assertEquals("Good", new MultiplicationTable2Easy().isGoodSet(table, t));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] table = new int[] {1, 1, 2, 3,
 1, 0, 2, 3,
 3, 3, 0, 3,
 2, 2, 2, 0};
		int[] t = new int[] {2, 3};
		assertEquals("Not Good", new MultiplicationTable2Easy().isGoodSet(table, t));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] table = new int[] {1, 1, 2, 3,
 1, 0, 2, 3,
 3, 3, 0, 3,
 2, 2, 2, 0}
;
		int[] t = new int[] {0,1,2,3};
		assertEquals("Good", new MultiplicationTable2Easy().isGoodSet(table, t));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] table = new int[] {1, 1, 2, 3,
 1, 0, 2, 3,
 3, 3, 0, 3,
 2, 2, 2, 0}
;
		int[] t = new int[] {1};
		assertEquals("Not Good", new MultiplicationTable2Easy().isGoodSet(table, t));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] table = new int[] {2,2,2,2,2,2,
 2,2,2,2,2,2,
 2,2,2,2,2,2,
 2,2,2,2,2,2,
 2,2,2,2,2,2,
 2,2,2,2,2,2};
		int[] t = new int[] {2,4,5};
		assertEquals("Good", new MultiplicationTable2Easy().isGoodSet(table, t));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] table = new int[] {2,2,2,2,2,2,
 2,2,2,2,2,2,
 2,2,2,2,2,2,
 2,2,2,2,2,2,
 2,2,2,2,2,2,
 2,2,2,2,2,2};
		int[] t = new int[] {0,1,3,4,5};
		assertEquals("Not Good", new MultiplicationTable2Easy().isGoodSet(table, t));
	}
}
