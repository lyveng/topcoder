import org.junit.Test;
import static org.junit.Assert.*;

public class ThreeTeleportsTest {
	
	@Test(timeout=2000)
	public void test0() {
		int xMe = 3;
		int yMe = 3;
		int xHome = 4;
		int yHome = 5;
		String[] teleports = new String[] {"1000 1001 1000 1002", "1000 1003 1000 1004", "1000 1005 1000 1006"};
		assertEquals(3, new ThreeTeleports().shortestDistance(xMe, yMe, xHome, yHome, teleports));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int xMe = 0;
		int yMe = 0;
		int xHome = 20;
		int yHome = 20;
		String[] teleports = new String[] {"1 1 18 20", "1000 1003 1000 1004", "1000 1005 1000 1006"};
		assertEquals(14, new ThreeTeleports().shortestDistance(xMe, yMe, xHome, yHome, teleports));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int xMe = 0;
		int yMe = 0;
		int xHome = 20;
		int yHome = 20;
		String[] teleports = new String[] {"1000 1003 1000 1004", "18 20 1 1", "1000 1005 1000 1006"};
		assertEquals(14, new ThreeTeleports().shortestDistance(xMe, yMe, xHome, yHome, teleports));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int xMe = 10;
		int yMe = 10;
		int xHome = 10000;
		int yHome = 20000;
		String[] teleports = new String[] {"1000 1003 1000 1004", "3 3 10004 20002", "1000 1005 1000 1006"};
		assertEquals(30, new ThreeTeleports().shortestDistance(xMe, yMe, xHome, yHome, teleports));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int xMe = 3;
		int yMe = 7;
		int xHome = 10000;
		int yHome = 30000;
		String[] teleports = new String[] {"3 10 5200 4900", "12212 8699 9999 30011", "12200 8701 5203 4845"};
		assertEquals(117, new ThreeTeleports().shortestDistance(xMe, yMe, xHome, yHome, teleports));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int xMe = 0;
		int yMe = 0;
		int xHome = 1000000000;
		int yHome = 1000000000;
		String[] teleports = new String[] {"0 1 0 999999999", "1 1000000000 999999999 0", "1000000000 1 1000000000 999999999"};
		assertEquals(36, new ThreeTeleports().shortestDistance(xMe, yMe, xHome, yHome, teleports));
	}
}
