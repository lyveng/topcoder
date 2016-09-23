import org.junit.Test;
import static org.junit.Assert.*;

public class PalindromePrimeTest {
	
	@Test(timeout=2000)
	public void test0() {
		int L = 100;
		int R = 150;
		assertEquals(2, new PalindromePrime().count(L, R));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int L = 1;
		int R = 9;
		assertEquals(4, new PalindromePrime().count(L, R));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int L = 929;
		int R = 929;
		assertEquals(1, new PalindromePrime().count(L, R));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int L = 1;
		int R = 1;
		assertEquals(0, new PalindromePrime().count(L, R));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int L = 1;
		int R = 1000;
		assertEquals(20, new PalindromePrime().count(L, R));
	}
}
