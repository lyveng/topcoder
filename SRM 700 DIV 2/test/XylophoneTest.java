import org.junit.Test;
import static org.junit.Assert.*;

public class XylophoneTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] keys = new int[] {1,8,3};
		assertEquals(2, new Xylophone().countKeys(keys));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] keys = new int[] {7,3,2,4,1,5,6};
		assertEquals(7, new Xylophone().countKeys(keys));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] keys = new int[] {1,8,15};
		assertEquals(1, new Xylophone().countKeys(keys));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] keys = new int[] {25,1,17,9,8};
		assertEquals(4, new Xylophone().countKeys(keys));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] keys = new int[] {11,11,11,11,11,11,11,11,11,11,11};
		assertEquals(1, new Xylophone().countKeys(keys));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] keys = new int[] {50,10,20,30,11,30,24,38,5,2,9};
		assertEquals(6, new Xylophone().countKeys(keys));
	}
}
