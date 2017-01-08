import org.junit.Test;
import static org.junit.Assert.*;

public class ArcadeManaoTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] level = new String[] {"XXXX....",
 "...X.XXX",
 "XXX..X..",
 "......X.",
 "XXXXXXXX"};
		int coinRow = 2;
		int coinColumn = 4;
		assertEquals(2, new ArcadeManao().shortestLadder(level, coinRow, coinColumn));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] level = new String[] {"XXXX",
 "...X",
 "XXXX"};
		int coinRow = 1;
		int coinColumn = 1;
		assertEquals(1, new ArcadeManao().shortestLadder(level, coinRow, coinColumn));
	}
	
	@Test(timeout=200000000)
	public void test2() {
		String[] level = new String[] {"..X..",
 ".X.X.",
 "X...X",
 ".X.X.",
 "..X..",
 "XXXXX"};
		int coinRow = 1;
		int coinColumn = 3;
		assertEquals(4, new ArcadeManao().shortestLadder(level, coinRow, coinColumn));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] level = new String[] {"X"};
		int coinRow = 1;
		int coinColumn = 1;
		assertEquals(0, new ArcadeManao().shortestLadder(level, coinRow, coinColumn));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] level = new String[] {"XXXXXXXXXX",
 "...X......",
 "XXX.......",
 "X.....XXXX",
 "..XXXXX..X",
 ".........X",
 ".........X",
 "XXXXXXXXXX"};
		int coinRow = 1;
		int coinColumn = 1;
		assertEquals(2, new ArcadeManao().shortestLadder(level, coinRow, coinColumn));
	}
}
