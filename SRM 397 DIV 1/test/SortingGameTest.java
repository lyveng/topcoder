import org.junit.Test;
import static org.junit.Assert.*;

public class SortingGameTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] board = new int[] {1,2,3};
		int k = 3;
		assertEquals(0, new SortingGame().fewestMoves(board, k));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] board = new int[] {3,2,1};
		int k = 3;
		assertEquals(1, new SortingGame().fewestMoves(board, k));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] board = new int[] {5,4,3,2,1};
		int k = 2;
		assertEquals(10, new SortingGame().fewestMoves(board, k));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] board = new int[] {3,2,4,1,5};
		int k = 4;
		assertEquals(-1, new SortingGame().fewestMoves(board, k));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] board = new int[] {7,2,1,6,8,4,3,5};
		int k = 4;
		assertEquals(7, new SortingGame().fewestMoves(board, k));
	}
}
