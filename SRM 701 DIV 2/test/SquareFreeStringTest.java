import org.junit.Test;
import static org.junit.Assert.*;

public class SquareFreeStringTest {
	
	@Test(timeout=2000)
	public void test0() {
		String s = "bobo";
		assertEquals("not square-free", new SquareFreeString().isSquareFree(s));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String s = "apple";
		assertEquals("not square-free", new SquareFreeString().isSquareFree(s));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String s = "pen";
		assertEquals("square-free", new SquareFreeString().isSquareFree(s));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String s = "aydyamrbnauhftmphyrooyq";
		assertEquals("not square-free", new SquareFreeString().isSquareFree(s));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String s = "qwertyuiopasdfghjklzxcvbnm";
		assertEquals("square-free", new SquareFreeString().isSquareFree(s));
	}
}
