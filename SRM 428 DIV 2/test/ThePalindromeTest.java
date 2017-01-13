import org.junit.Test;
import static org.junit.Assert.*;

public class ThePalindromeTest {
	
	@Test(timeout=2000)
	public void test0() {
		String s = "abab";
		assertEquals(5, new ThePalindrome().find(s));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String s = "abacaba";
		assertEquals(7, new ThePalindrome().find(s));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String s = "qwerty";
		assertEquals(11, new ThePalindrome().find(s));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String s = "abdfhdyrbdbsdfghjkllkjhgfds";
		assertEquals(38, new ThePalindrome().find(s));
	}
}
