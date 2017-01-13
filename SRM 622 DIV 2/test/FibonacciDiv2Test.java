import org.junit.Test;
import static org.junit.Assert.*;

public class FibonacciDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 1;
		assertEquals(0, new FibonacciDiv2().find(N));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 13;
		assertEquals(0, new FibonacciDiv2().find(N));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 15;
		assertEquals(2, new FibonacciDiv2().find(N));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int N = 19;
		assertEquals(2, new FibonacciDiv2().find(N));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int N = 1000000;
		assertEquals(167960, new FibonacciDiv2().find(N));
	}
}
