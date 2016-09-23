import org.junit.Test;
import static org.junit.Assert.*;

public class LiveConcertTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] h = new int[] {10,5,6,7,1,2};
		String[] s = new String[] {"ciel","bessie","john","bessie","bessie","john"};
		assertEquals(23, new LiveConcert().maxHappiness(h, s));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] h = new int[] {3,3,4,3,3};
		String[] s = new String[] {"a","a","a","a","a"};
		assertEquals(4, new LiveConcert().maxHappiness(h, s));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] h = new int[] {1,2,3,4,5,6,7,8,9,10,100};
		String[] s = new String[] {"a","b","c","d","e","e","d","c","b","a","abcde"};
		assertEquals(140, new LiveConcert().maxHappiness(h, s));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] h = new int[] {100};
		String[] s = new String[] {"oyusop"};
		assertEquals(100, new LiveConcert().maxHappiness(h, s));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] h = new int[] {100,100,100,100,100,100,100,100,100,100,100,100,100};
		String[] s = new String[] {"haruka","chihaya","yayoi","iori","yukiho","makoto","ami","mami","azusa","miki","hibiki","takane","ritsuko"};
		assertEquals(1300, new LiveConcert().maxHappiness(h, s));
	}
}
