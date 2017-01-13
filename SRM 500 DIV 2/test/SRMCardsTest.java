import org.junit.Test;
import static org.junit.Assert.*;

public class SRMCardsTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] cards = new int[] {498, 499};
		assertEquals(1, new SRMCards().maxTurns(cards));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] cards = new int[] {491, 492, 495, 497, 498, 499};
		assertEquals(4, new SRMCards().maxTurns(cards));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] cards = new int[] {100, 200, 300, 400};
		assertEquals(4, new SRMCards().maxTurns(cards));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] cards = new int[] {11, 12, 102, 13, 100, 101, 99, 9, 8, 1};
		assertEquals(6, new SRMCards().maxTurns(cards));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] cards = new int[] {118, 321, 322, 119, 120, 320};
		assertEquals(4, new SRMCards().maxTurns(cards));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] cards = new int[] {10, 11, 12, 13, 14, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		assertEquals(7, new SRMCards().maxTurns(cards));
	}
}
