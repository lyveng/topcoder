import org.junit.Test;
import static org.junit.Assert.*;

public class BearCheatsTest {
	
	@Test(timeout=2000)
	public void test0() {
		int A = 8072;
		int B = 3072;
		assertEquals("happy", new BearCheats().eyesight(A, B));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int A = 508;
		int B = 540;
		assertEquals("glasses", new BearCheats().eyesight(A, B));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int A = 854000;
		int B = 854000;
		assertEquals("happy", new BearCheats().eyesight(A, B));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int A = 1;
		int B = 6;
		assertEquals("happy", new BearCheats().eyesight(A, B));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int A = 385900;
		int B = 123000;
		assertEquals("glasses", new BearCheats().eyesight(A, B));
	}
}
