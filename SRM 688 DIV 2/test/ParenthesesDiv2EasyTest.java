import org.junit.Test;
import static org.junit.Assert.*;

public class ParenthesesDiv2EasyTest {
	
	@Test(timeout=2000)
	public void test0() {
		String s = "(())";
		assertEquals(2, new ParenthesesDiv2Easy().getDepth(s));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String s = "()()()";
		assertEquals(1, new ParenthesesDiv2Easy().getDepth(s));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String s = "(())()";
		assertEquals(2, new ParenthesesDiv2Easy().getDepth(s));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String s = "((())())(((())(()))())";
		assertEquals(4, new ParenthesesDiv2Easy().getDepth(s));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String s = "()";
		assertEquals(1, new ParenthesesDiv2Easy().getDepth(s));
	}
}
