import org.junit.Test;
import static org.junit.Assert.*;

public class ListeningSongsTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] durations1 = new int[] {300,200,100};
		int[] durations2 = new int[] {400,500,600};
		int minutes = 17;
		int T = 1;
		assertEquals(4, new ListeningSongs().listen(durations1, durations2, minutes, T));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] durations1 = new int[] {300,200,100};
		int[] durations2 = new int[] {400,500,600};
		int minutes = 10;
		int T = 1;
		assertEquals(2, new ListeningSongs().listen(durations1, durations2, minutes, T));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] durations1 = new int[] {60,60,60};
		int[] durations2 = new int[] {60,60,60};
		int minutes = 5;
		int T = 2;
		assertEquals(5, new ListeningSongs().listen(durations1, durations2, minutes, T));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] durations1 = new int[] {120,120,120,120,120};
		int[] durations2 = new int[] {60,60,60,60,60,60};
		int minutes = 10;
		int T = 3;
		assertEquals(7, new ListeningSongs().listen(durations1, durations2, minutes, T));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] durations1 = new int[] {196,147,201,106,239,332,165,130,205,221,248,108,60};
		int[] durations2 = new int[] {280,164,206,95,81,383,96,255,260,244,60,313,101};
		int minutes = 60;
		int T = 3;
		assertEquals(22, new ListeningSongs().listen(durations1, durations2, minutes, T));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] durations1 = new int[] {100,200,300};
		int[] durations2 = new int[] {100,200,300};
		int minutes = 2;
		int T = 1;
		assertEquals(-1, new ListeningSongs().listen(durations1, durations2, minutes, T));
	}
	
	@Test(timeout=2000)
	public void test6() {
		int[] durations1 = new int[] {100,200,300,400,500,600};
		int[] durations2 = new int[] {100,200};
		int minutes = 1000;
		int T = 3;
		assertEquals(-1, new ListeningSongs().listen(durations1, durations2, minutes, T));
	}

	@Test(timeout=2000)
	public void test7() {
		int[] durations1 = new int[] {100,200,300,400,500,600};
		int[] durations2 = new int[] {100,200};
		int minutes = 1000;
		int T = 3;
		assertEquals(-1, new ListeningSongs().listen(durations1, durations2, minutes, T));
	}
}
