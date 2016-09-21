import org.junit.Test;
import static org.junit.Assert.*;

public class QuorumTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] arr = new int[] {5,2,3};
		int k = 1;
		assertEquals(2, new Quorum().count(arr, k));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] arr = new int[] {1,1,1,1,1};
		int k = 5;
		assertEquals(5, new Quorum().count(arr, k));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] arr = new int[] {50,2,9,49,38};
		int k = 3;
		assertEquals(49, new Quorum().count(arr, k));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] arr = new int[] {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		int k = 14;
		assertEquals(105, new Quorum().count(arr, k));
	}
}
