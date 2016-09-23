import org.junit.Test;
import static org.junit.Assert.*;

public class CdgameTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] a = new int[] {1,2};
		int[] b = new int[] {3,4};
		assertEquals(2, new Cdgame().rescount(a, b));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] a = new int[] {1,2,4};
		int[] b = new int[] {8,16,32};
		assertEquals(9, new Cdgame().rescount(a, b));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] a = new int[] {1,1,1};
		int[] b = new int[] {1,1,1};
		assertEquals(1, new Cdgame().rescount(a, b));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] a = new int[] {1,2,3};
		int[] b = new int[] {5,5,5};
		assertEquals(3, new Cdgame().rescount(a, b));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] a = new int[] {3,3,4,1};
		int[] b = new int[] {2,2,2,100};
		assertEquals(4, new Cdgame().rescount(a, b));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] a = new int[] {31,34,55,56,57};
		int[] b = new int[] {1,2,3,4,5};
		assertEquals(15, new Cdgame().rescount(a, b));
	}
}
