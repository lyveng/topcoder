import org.junit.Test;
import static org.junit.Assert.*;

public class Sunnygraphs2Test {
	
	@Test(timeout=2000)
	public void test0() {
		int[] a = new int[] {1,0};
		assertEquals(4L, new Sunnygraphs2().count(a));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] a = new int[] {1,0,0};
		assertEquals(7L, new Sunnygraphs2().count(a));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] a = new int[] {2,3,0,1};
		assertEquals(9L, new Sunnygraphs2().count(a));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] a = new int[] {2,3,0,1,0};
		assertEquals(18L, new Sunnygraphs2().count(a));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] a = new int[] {2,3,0,1,0,4,5,2,3};
		assertEquals(288L, new Sunnygraphs2().count(a));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] a = new int[] {29,34,40,17,16,12,0,40,20,35,5,13,27,7,29,13,14,39,42,9,30,38,27,40,34,33,42,20,29,42,12,29,30,21,4,5,7,25,24,17,39,32,9};
		assertEquals(6184752906240L, new Sunnygraphs2().count(a));
	}
	
	@Test(timeout=2000)
	public void test6() {
		int[] a = new int[] {9,2,0,43,12,14,39,25,24,3,16,17,22,0,6,21,18,29,34,35,23,43,28,28,20,11,5,12,31,24,8,13,17,10,15,9,15,26,4,13,21,27,36,39};
		assertEquals(17317308137473L, new Sunnygraphs2().count(a));
	}
}
