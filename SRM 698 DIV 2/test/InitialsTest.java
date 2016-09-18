import org.junit.Test;
import static org.junit.Assert.*;

public class InitialsTest {
	
	@Test(timeout=2000)
	public void test0() {
		String name = "john fitzgerald kennedy";
		assertEquals("jfk", new Initials().getInitials(name));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String name = "single";
		assertEquals("s", new Initials().getInitials(name));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String name = "looks good to me";
		assertEquals("lgtm", new Initials().getInitials(name));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String name = "single round match";
		assertEquals("srm", new Initials().getInitials(name));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String name = "a aa aaa aa a bbb bb b bb bbb";
		assertEquals("aaaaabbbbb", new Initials().getInitials(name));
	}
}
