import org.junit.Test;
import static org.junit.Assert.*;

public class PipeCutsTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] weldLocations = new int[] {25, 50, 75};
		int L = 25;
		assertEquals(1.0, new PipeCuts().probability(weldLocations, L), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] weldLocations = new int[] {25, 50, 75};
		int L = 50;
		assertEquals(0.0, new PipeCuts().probability(weldLocations, L), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] weldLocations = new int[] {25, 50, 75};
		int L = 24;
		assertEquals(1.0, new PipeCuts().probability(weldLocations, L), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] weldLocations = new int[] {99, 88, 77, 66, 55, 44, 33, 22, 11};
		int L = 50;
		assertEquals(0.7222222222222222, new PipeCuts().probability(weldLocations, L), 1e-9);
	}
}
