import org.junit.Test;
import static org.junit.Assert.*;

public class PlusonegameTest {
	
	@Test(timeout=2000)
	public void test0() {
		String s = "1++";
		assertEquals("+1+", new Plusonegame().getorder(s));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String s = "549";
		assertEquals("459", new Plusonegame().getorder(s));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String s = "++++++";
		assertEquals("++++++", new Plusonegame().getorder(s));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String s = "+++++2+";
		assertEquals("++2++++", new Plusonegame().getorder(s));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String s = "++++4++++200++2++1+6++++++";
		assertEquals("00+1+22++4++6+++++++++++++", new Plusonegame().getorder(s));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String s = "++11199999";
		assertEquals("+111+99999", new Plusonegame().getorder(s));
	}

	@Test(timeout=2000)
	public void test6() {
		String s = "+9878";
		assertEquals("+7889", new Plusonegame().getorder(s));
	}
}
