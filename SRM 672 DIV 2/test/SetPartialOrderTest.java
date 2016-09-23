import org.junit.Test;
import static org.junit.Assert.*;

public class SetPartialOrderTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] a = new int[] {1, 2, 3, 5, 8};
		int[] b = new int[] {8, 5, 1, 3, 2};
		assertEquals("EQUAL", new SetPartialOrder().compareSets(a, b));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] a = new int[] {2, 3, 5, 7};
		int[] b = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertEquals("LESS", new SetPartialOrder().compareSets(a, b));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] a = new int[] {2, 4, 6, 8, 10, 12, 14, 16};
		int[] b = new int[] {2, 4, 8, 16};
		assertEquals("GREATER", new SetPartialOrder().compareSets(a, b));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] a = new int[] {42, 23, 17};
		int[] b = new int[] {15, 23, 31};
		assertEquals("INCOMPARABLE", new SetPartialOrder().compareSets(a, b));
	}
}
