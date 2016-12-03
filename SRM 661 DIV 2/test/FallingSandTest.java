import org.junit.Test;
import static org.junit.Assert.*;

public class FallingSandTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] board = new String[] {"ooooo",
 "..x..",
 "....x",
 ".....",
 "....o"};
		assertArrayEquals(new String[] {"..o..", "..x.o", "....x", ".....", "oo.oo" }, new FallingSand().simulate(board));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] board = new String[] {"..o..", 
 "..x.o", 
 "....x", 
 ".....", 
 "oo.oo" };
		assertArrayEquals(new String[] {"..o..", "..x.o", "....x", ".....", "oo.oo" }, new FallingSand().simulate(board));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] board = new String[] {"ooooxooo.ooxo.oxoxoooox.....x.oo"};
		assertArrayEquals(new String[] {"ooooxooo.ooxo.oxoxoooox.....x.oo" }, new FallingSand().simulate(board));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] board = new String[] {"o",
 ".",
 "o",
 ".",
 "o",
 ".",
 "."};
		assertArrayEquals(new String[] {".", ".", ".", ".", "o", "o", "o" }, new FallingSand().simulate(board));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] board = new String[] {"oxxxxooo",
 "xooooxxx",
 "..xx.ooo",
 "oooox.o.",
 "..x....."};
		assertArrayEquals(new String[] {"oxxxxooo", "x.oo.xxx", "..xxo...", ".oo.x.o.", "ooxo.ooo" }, new FallingSand().simulate(board));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String[] board = new String[] {"..o..o..o..o..o..o..o..o..o..o..o",
 "o..o..o..o..o..o..o..o..o..o..o..",
 ".o..o..o..o..o..o..o..o..o..o..o.",
 "...xxx...xxx...xxxxxxxxx...xxx...",
 "...xxx...xxx...xxxxxxxxx...xxx...",
 "...xxx...xxx......xxx......xxx...",
 "...xxxxxxxxx......xxx......xxx...",
 "...xxxxxxxxx......xxx......xxx...",
 "...xxxxxxxxx......xxx......xxx...",
 "...xxx...xxx......xxx............",
 "...xxx...xxx...xxxxxxxxx...xxx...",
 "...xxx...xxx...xxxxxxxxx...xxx...",
 "..o..o..o..o..o..o..o..o..o..o..o",
 "o..o..o..o..o..o..o..o..o..o..o..",
 ".o..o..o..o..o..o..o..o..o..o..o."};
		assertArrayEquals(new String[] {".................................", ".................................", "...ooo...ooo...ooooooooo...ooo...", "...xxx...xxx...xxxxxxxxx...xxx...", "...xxx...xxx...xxxxxxxxx...xxx...", "...xxxoooxxx......xxx......xxx...", "...xxxxxxxxx......xxx......xxx...", "...xxxxxxxxx......xxx......xxx...", "...xxxxxxxxx......xxx......xxx...", "...xxx...xxx......xxx............", "...xxx...xxx...xxxxxxxxx...xxx...", "...xxx...xxx...xxxxxxxxx...xxx...", ".................................", "ooo.........ooo.........ooo...ooo", "ooooooooooooooooooooooooooooooooo" }, new FallingSand().simulate(board));
	}
}
