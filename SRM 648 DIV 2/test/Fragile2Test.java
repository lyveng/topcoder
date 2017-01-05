import org.junit.Test;
import static org.junit.Assert.*;

public class Fragile2Test {
	
	@Test(timeout=2000)
	public void test0() {
		String[] graph = new String[] {"NYNN", "YNYN", "NYNY", "NNYN"};
		assertEquals(3, new Fragile2().countPairs(graph));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] graph = new String[] {"NYNNNN", "YNYNNN", "NYNNNN", "NNNNYN", "NNNYNY", "NNNNYN"};
		assertEquals(5, new Fragile2().countPairs(graph));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] graph = new String[] {"NNN", "NNN", "NNN"};
		assertEquals(0, new Fragile2().countPairs(graph));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] graph = new String[] {"NYNYNNYYNN", "YNNNYNYYNN", "NNNNYNNNYN", "YNNNYYNNNN", "NYYYNNNNYN",
 "NNNYNNNNYN", "YYNNNNNNNN", "YYNNNNNNYN", "NNYNYYNYNY", "NNNNNNNNYN"};
		assertEquals(9, new Fragile2().countPairs(graph));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] graph = new String[] {"NNNYNNYNNNNNNNYYNNNY", "NNNNNNNNYNNNNNNNNNNN", "NNNNNNNNNNNNNNNNNNNN", "YNNNNNNNNNYNNNNNNNNN", "NNNNNNNYNNNNNYNNNNYN",
 "NNNNNNNNNNNNNNNNYNNY", "YNNNNNNNNNNNNYYYNYNN", "NNNNYNNNNNNNNYYNNNNN", "NYNNNNNNNYNNNNNNNNNN", "NNNNNNNNYNNNYNNNNNYN",
 "NNNYNNNNNNNNNNYNNNNN", "NNNNNNNNNNNNNNNNNNNN", "NNNNNNNNNYNNNNNNNYNN", "NNNNYNYYNNNNNNNNNNNN", "YNNNNNYYNNYNNNNNNNNN",
 "YNNNNNYNNNNNNNNNYNNN", "NNNNNYNNNNNNNNNYNYNN", "NNNNNNYNNNNNYNNNYNNN", "NNNNYNNNNYNNNNNNNNNN", "YNNNNYNNNNNNNNNNNNNN"};
		assertEquals(42, new Fragile2().countPairs(graph));
	}
}
