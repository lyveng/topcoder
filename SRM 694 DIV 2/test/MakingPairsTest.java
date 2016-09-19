import org.junit.Test;
import static org.junit.Assert.*;

public class MakingPairsTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] card = new int[] {2,2,2};
		assertEquals(3, new MakingPairs().get(card));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] card = new int[] {1,1,1};
		assertEquals(0, new MakingPairs().get(card));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] card = new int[] {5};
		assertEquals(2, new MakingPairs().get(card));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] card = new int[] {43,23,10,39,39,22,22,0,3,4,3,2};
		assertEquals(102, new MakingPairs().get(card));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] card = new int[] {0};
		assertEquals(0, new MakingPairs().get(card));
	}
}
