import org.junit.Test;
import static org.junit.Assert.*;

public class BearNSWETest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] a = new int[] {1,3,3};
		String dir = "NES";
		assertEquals(10.60555127546399, new BearNSWE().totalDistance(a, dir), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] a = new int[] {10,10,10,10};
		String dir = "NWSE";
		assertEquals(40.0, new BearNSWE().totalDistance(a, dir), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] a = new int[] {10,10,10,15,8,20,5};
		String dir = "NEWEWWE";
		assertEquals(90.8062484748657, new BearNSWE().totalDistance(a, dir), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] a = new int[] {42};
		String dir = "E";
		assertEquals(84.0, new BearNSWE().totalDistance(a, dir), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] a = new int[] {10,40,40};
		String dir = "NSE";
		assertEquals(140.0, new BearNSWE().totalDistance(a, dir), 1e-9);
	}
}
