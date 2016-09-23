import org.junit.Test;
import static org.junit.Assert.*;

public class LuckyXorTest {
	
	@Test(timeout=2000)
	public void test0() {
		int a = 4;
		assertEquals(40, new LuckyXor().construct(a));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int a = 19;
		assertEquals(20, new LuckyXor().construct(a));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int a = 88;
		assertEquals(92, new LuckyXor().construct(a));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int a = 36;
		assertEquals(-1, new LuckyXor().construct(a));
	}
}
