import org.junit.Test;
import static org.junit.Assert.*;

public class ThePhantomMenaceTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] doors = new int[] {1,2,3,4};
		int[] droids = new int[] {5,6,7,8};
		assertEquals(4, new ThePhantomMenace().find(doors, droids));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] doors = new int[] {1};
		int[] droids = new int[] {10};
		assertEquals(9, new ThePhantomMenace().find(doors, droids));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] doors = new int[] {2,3,5,7,11};
		int[] droids = new int[] {1,8,13};
		assertEquals(3, new ThePhantomMenace().find(doors, droids));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] doors = new int[] {1,3,5,7,9,11,13,15,17,19};
		int[] droids = new int[] {2,4,6,8,10,12,14,16,18,20};
		assertEquals(1, new ThePhantomMenace().find(doors, droids));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] doors = new int[] {2,1};
		int[] droids = new int[] {4,3};
		assertEquals(2, new ThePhantomMenace().find(doors, droids));
	}
}
