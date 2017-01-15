import org.junit.Test;
import static org.junit.Assert.*;

public class QuizShowTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] scores = new int[] { 100, 100, 100 };
		int wager1 = 25;
		int wager2 = 75;
		assertEquals(76, new QuizShow().wager(scores, wager1, wager2));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] scores = new int[] { 10, 50, 60 };
		int wager1 = 30;
		int wager2 = 41;
		assertEquals(0, new QuizShow().wager(scores, wager1, wager2));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] scores = new int[] { 10, 50, 60 };
		int wager1 = 31;
		int wager2 = 41;
		assertEquals(10, new QuizShow().wager(scores, wager1, wager2));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] scores = new int[] { 2, 2, 12 };
		int wager1 = 0;
		int wager2 = 10;
		assertEquals(1, new QuizShow().wager(scores, wager1, wager2));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] scores = new int[] { 10000, 10000, 10000 };
		int wager1 = 9998;
		int wager2 = 9997;
		assertEquals(9999, new QuizShow().wager(scores, wager1, wager2));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] scores = new int[] { 5824, 4952, 6230 };
		int wager1 = 364;
		int wager2 = 287;
		assertEquals(694, new QuizShow().wager(scores, wager1, wager2));
	}
}
