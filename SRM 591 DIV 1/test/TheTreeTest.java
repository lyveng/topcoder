import org.junit.Test;
import static org.junit.Assert.*;

public class TheTreeTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] cnt = new int[] {3};
		assertEquals(2, new TheTree().maximumDiameter(cnt));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] cnt = new int[] {2, 2};
		assertEquals(4, new TheTree().maximumDiameter(cnt));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] cnt = new int[] {4, 1, 2, 4};
		assertEquals(5, new TheTree().maximumDiameter(cnt));
	}
	
	@Test(timeout=200000000)
	public void test3() {
		int[] cnt = new int[] {4, 2, 1, 3, 2, 5, 7, 2, 4, 5, 2, 3, 1, 13, 6};
		assertEquals(21, new TheTree().maximumDiameter(cnt));
	}
}
