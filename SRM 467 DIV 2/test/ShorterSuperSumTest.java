import org.junit.Test;
import static org.junit.Assert.*;

public class ShorterSuperSumTest {
	
	@Test(timeout=2000)
	public void test0() {
		int k = 1;
		int n = 3;
		assertEquals(6, new ShorterSuperSum().calculate(k, n));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int k = 2;
		int n = 3;
		assertEquals(10, new ShorterSuperSum().calculate(k, n));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int k = 4;
		int n = 10;
		assertEquals(2002, new ShorterSuperSum().calculate(k, n));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int k = 10;
		int n = 10;
		assertEquals(167960, new ShorterSuperSum().calculate(k, n));
	}
}
