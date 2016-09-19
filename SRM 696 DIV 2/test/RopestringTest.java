import org.junit.Test;
import static org.junit.Assert.*;

public class RopestringTest {
	
	@Test(timeout=2000)
	public void test0() {
		String s = "..-..-";
		assertEquals("-.-...", new Ropestring().makerope(s));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String s = "-.-";
		assertEquals("-.-", new Ropestring().makerope(s));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String s = "--..-.---..--";
		assertEquals("--.--.---.-..", new Ropestring().makerope(s));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String s = "--..-.---..--..-----.--.";
		assertEquals("--.--.--.-----.---.-....", new Ropestring().makerope(s));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String s = "...";
		assertEquals("...", new Ropestring().makerope(s));
	}
}
