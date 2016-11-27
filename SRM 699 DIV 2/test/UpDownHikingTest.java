import org.junit.Test;
import static org.junit.Assert.*;

public class UpDownHikingTest {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 3;
		int A = 7;
		int B = 10;
		assertEquals(10, new UpDownHiking().maxHeight(N, A, B));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 5;
		int A = 40;
		int B = 30;
		assertEquals(80, new UpDownHiking().maxHeight(N, A, B));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 2;
		int A = 50;
		int B = 1;
		assertEquals(1, new UpDownHiking().maxHeight(N, A, B));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int N = 3;
		int A = 42;
		int B = 42;
		assertEquals(42, new UpDownHiking().maxHeight(N, A, B));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int N = 20;
		int A = 7;
		int B = 9;
		assertEquals(77, new UpDownHiking().maxHeight(N, A, B));
	}
}
