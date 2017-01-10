import org.junit.Test;
import static org.junit.Assert.*;

public class BuildingRoutesTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] dist = new String[] {"011",
 "101",
 "110"};
		int T = 1;
		assertEquals(6, new BuildingRoutes().build(dist, T));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] dist = new String[] {"033",
 "309",
 "390"};
		int T = 1;
		assertEquals(12, new BuildingRoutes().build(dist, T));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] dist = new String[] {"0123",
 "1023",
 "1203",
 "1230"};
		int T = 2;
		assertEquals(5, new BuildingRoutes().build(dist, T));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] dist = new String[] {"05789654",
 "10347583",
 "65085479",
 "55602398",
 "76590934",
 "57939045",
 "12345608",
 "68647640"};
		int T = 3;
		assertEquals(40, new BuildingRoutes().build(dist, T));
	}
}
