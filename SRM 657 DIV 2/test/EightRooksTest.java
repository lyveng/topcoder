import org.junit.Test;
import static org.junit.Assert.*;

public class EightRooksTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] board = new String[] {"R.......",
 ".R......",
 "..R.....",
 "...R....",
 "....R...",
 ".....R..",
 "......R.",
 ".......R"};
		assertEquals("Correct", new EightRooks().isCorrect(board));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] board = new String[] {"........",
 "....R...",
 "........",
 ".R......",
 "........",
 "........",
 "..R.....",
 "........"};
		assertEquals("Incorrect", new EightRooks().isCorrect(board));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] board = new String[] {"......R.",
 "....R...",
 "...R....",
 ".R......",
 "R.......",
 ".....R..",
 "..R.....",
 ".......R"};
		assertEquals("Correct", new EightRooks().isCorrect(board));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] board = new String[] {"......R.",
 "....R...",
 "...R....",
 ".R......",
 "R.......",
 ".......R",
 "..R.....",
 ".......R"};
		assertEquals("Incorrect", new EightRooks().isCorrect(board));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] board = new String[] {"........",
 "........",
 "........",
 "........",
 "........",
 "........",
 "........",
 "........"};
		assertEquals("Incorrect", new EightRooks().isCorrect(board));
	}
}
