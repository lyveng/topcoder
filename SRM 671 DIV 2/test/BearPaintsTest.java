import org.junit.Test;
import static org.junit.Assert.*;

public class BearPaintsTest {
	
	@Test(timeout=2000)
	public void test0() {
		int W = 3;
		int H = 5;
		long M = 14L;
		assertEquals(12L, new BearPaints().maxArea(W, H, M));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int W = 4;
		int H = 4;
		long M = 10L;
		assertEquals(9L, new BearPaints().maxArea(W, H, M));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int W = 1000000;
		int H = 12345;
		long M = 1000000000000L;
		assertEquals(12345000000L, new BearPaints().maxArea(W, H, M));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int W = 1000000;
		int H = 1000000;
		long M = 720000000007L;
		assertEquals(720000000000L, new BearPaints().maxArea(W, H, M));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int W = 1000000;
		int H = 1000000;
		long M = 999999999999L;
		assertEquals(999999000000L, new BearPaints().maxArea(W, H, M));
	}
}
