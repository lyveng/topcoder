import org.junit.Test;
import static org.junit.Assert.*;

public class CorruptedMessageTest {
	
	@Test(timeout=2000)
	public void test0() {
		String s = "hello";
		int k = 3;
		assertEquals("lllll", new CorruptedMessage().reconstructMessage(s, k));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String s = "abc";
		int k = 3;
		assertEquals("ddd", new CorruptedMessage().reconstructMessage(s, k));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String s = "wwwwwwwwwwwwwwwwww";
		int k = 0;
		assertEquals("wwwwwwwwwwwwwwwwww", new CorruptedMessage().reconstructMessage(s, k));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String s = "ababba";
		int k = 3;
		assertEquals("aaaaaa", new CorruptedMessage().reconstructMessage(s, k));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String s = "zoztxtoxytyt";
		int k = 10;
		assertEquals("oooooooooooo", new CorruptedMessage().reconstructMessage(s, k));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String s = "jlmnmiunaxzywed";
		int k = 13;
		assertEquals("mmmmmmmmmmmmmmm", new CorruptedMessage().reconstructMessage(s, k));
	}

	@Test(timeout=2000)
	public void test6() {
		String s = "exwtxfhylzwdvxkrnyommyxktqrfpyhvwkagjas";
		int k = 38;
		assertEquals("ddddddddddddddddddddddddddddddddddddddd", new CorruptedMessage().reconstructMessage(s, k));
	}
}
