import org.junit.Test;
import static org.junit.Assert.*;

public class SortingSubsetsTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] a = new int[] {3, 2, 1};
		assertEquals(2, new SortingSubsets().getMinimalSize(a));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] a = new int[] {1, 2, 3, 4};
		assertEquals(0, new SortingSubsets().getMinimalSize(a));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] a = new int[] {4, 4, 4, 3, 3, 3};
		assertEquals(6, new SortingSubsets().getMinimalSize(a));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] a = new int[] {11, 11, 49, 7, 11, 11, 7, 7, 11, 49, 11};
		assertEquals(7, new SortingSubsets().getMinimalSize(a));
	}
}
