import org.junit.Test;
import static org.junit.Assert.*;

public class BearSongTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] notes = new int[] {9,10,7,8,9};
		assertEquals(3, new BearSong().countRareNotes(notes));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] notes = new int[] {8,8,7,6,7,3,5,10,9,3};
		assertEquals(4, new BearSong().countRareNotes(notes));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] notes = new int[] {234,462,715,596,906};
		assertEquals(5, new BearSong().countRareNotes(notes));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] notes = new int[] {17};
		assertEquals(1, new BearSong().countRareNotes(notes));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] notes = new int[] {1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};
		assertEquals(0, new BearSong().countRareNotes(notes));
	}
}
