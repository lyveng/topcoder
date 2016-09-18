import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleMakingTest {
	
	@Test(timeout=2000)
	public void test0() {
		int a = 1;
		int b = 2;
		int c = 3;
		assertEquals(5, new TriangleMaking().maxPerimeter(a, b, c));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int a = 2;
		int b = 2;
		int c = 2;
		assertEquals(6, new TriangleMaking().maxPerimeter(a, b, c));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int a = 1;
		int b = 100;
		int c = 1;
		assertEquals(3, new TriangleMaking().maxPerimeter(a, b, c));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int a = 41;
		int b = 64;
		int c = 16;
		assertEquals(113, new TriangleMaking().maxPerimeter(a, b, c));
	}
}
