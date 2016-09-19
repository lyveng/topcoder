import org.junit.Test;
import static org.junit.Assert.*;

public class PriorityQueueTest {
	
	@Test(timeout=2000)
	public void test0() {
		String S = "bbbbb";
		int[] a = new int[] {1,1,1,1,1};
		assertEquals(10, new PriorityQueue().findAnnoyance(S, a));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String S = "bee";
		int[] a = new int[] {50,40,30};
		assertEquals(0, new PriorityQueue().findAnnoyance(S, a));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String S = "ebbe";
		int[] a = new int[] {5,2,11,1};
		assertEquals(12, new PriorityQueue().findAnnoyance(S, a));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String S = "bbeebeebeeeebbb";
		int[] a = new int[] {58,517,301,524,79,375,641,152,810,778,222,342,911,313,336};
		assertEquals(20485, new PriorityQueue().findAnnoyance(S, a));
	}
}
