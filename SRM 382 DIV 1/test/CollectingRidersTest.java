import org.junit.Test;
import static org.junit.Assert.*;

public class CollectingRidersTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] board = new String[] {"...1",
 "....",
 "2..."};
		assertEquals(2, new CollectingRiders().minimalMoves(board));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] board = new String[] {"........",
 ".1......",
 "........",
 "....3...",
 "........",
 "........",
 ".7......",
 "........"};
		assertEquals(2, new CollectingRiders().minimalMoves(board));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] board = new String[] {"..",
 "2.",
 ".."};
		assertEquals(0, new CollectingRiders().minimalMoves(board));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] board = new String[] {".1....1."};
		assertEquals(-1, new CollectingRiders().minimalMoves(board));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] board = new String[] {"9133632343",
 "5286698232",
 "8329333369",
 "5425579782",
 "4465864375",
 "8192124686",
 "3191624314",
 "5198496853",
 "1638163997",
 "6457337215"};
		assertEquals(121, new CollectingRiders().minimalMoves(board));
	}

	@Test(timeout=2000)
	public void test5() {
		String[] board = new String[] {"1...1",
				"....."};
		assertEquals(2, new CollectingRiders().minimalMoves(board));
	}
}
