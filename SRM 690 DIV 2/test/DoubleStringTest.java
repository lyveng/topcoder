import org.junit.Test;
import static org.junit.Assert.*;

public class DoubleStringTest {
	
	@Test(timeout=2000)
	public void test0() {
		String S = "MAZAIMAZAI";
		assertEquals("square", new DoubleString().check(S));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String S = "MAMAZAIZAI";
		assertEquals("not square", new DoubleString().check(S));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String S = "IOI";
		assertEquals("not square", new DoubleString().check(S));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String S = "AA";
		assertEquals("square", new DoubleString().check(S));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String S = "ABCCBA";
		assertEquals("not square", new DoubleString().check(S));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String S = "Y";
		assertEquals("not square", new DoubleString().check(S));
	}
}
