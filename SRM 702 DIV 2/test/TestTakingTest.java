import org.junit.Test;
import static org.junit.Assert.*;

public class TestTakingTest {
	
	@Test(timeout=2000)
	public void test0() {
		int questions = 3;
		int guessed = 1;
		int actual = 2;
		assertEquals(2, new TestTaking().findMax(questions, guessed, actual));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int questions = 3;
		int guessed = 2;
		int actual = 1;
		assertEquals(2, new TestTaking().findMax(questions, guessed, actual));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int questions = 5;
		int guessed = 5;
		int actual = 0;
		assertEquals(0, new TestTaking().findMax(questions, guessed, actual));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int questions = 10;
		int guessed = 8;
		int actual = 8;
		assertEquals(10, new TestTaking().findMax(questions, guessed, actual));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int questions = 7;
		int guessed = 0;
		int actual = 2;
		assertEquals(5, new TestTaking().findMax(questions, guessed, actual));
	}
}
