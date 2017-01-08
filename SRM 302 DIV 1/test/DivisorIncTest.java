import org.junit.Test;
import static org.junit.Assert.*;

public class DivisorIncTest {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 4;
		int M = 24;
		assertEquals(5, new DivisorInc().countOperations(N, M));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 4;
		int M = 576;
		assertEquals(14, new DivisorInc().countOperations(N, M));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 8748;
		int M = 83462;
		assertEquals(10, new DivisorInc().countOperations(N, M));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int N = 235;
		int M = 98234;
		assertEquals(21, new DivisorInc().countOperations(N, M));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int N = 4;
		int M = 99991;
		assertEquals(-1, new DivisorInc().countOperations(N, M));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int N = 82736;
		int M = 82736;
		assertEquals(0, new DivisorInc().countOperations(N, M));
	}
}
