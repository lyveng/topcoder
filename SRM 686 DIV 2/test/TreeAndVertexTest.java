import org.junit.Test;
import static org.junit.Assert.*;

public class TreeAndVertexTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] tree = new int[] {0,0,0};
		assertEquals(3, new TreeAndVertex().get(tree));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] tree = new int[] {0, 1, 2, 3};
		assertEquals(2, new TreeAndVertex().get(tree));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] tree = new int[] {0, 0, 2, 2};
		assertEquals(3, new TreeAndVertex().get(tree));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] tree = new int[] {0, 0, 0, 1, 1, 1};
		assertEquals(4, new TreeAndVertex().get(tree));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] tree = new int[] {0, 1, 2, 0, 1, 5, 6, 1, 7, 4, 2, 5, 5, 8, 6, 2, 14, 12, 18, 10, 0, 6, 18, 2, 20, 11, 0, 11, 7, 12, 17, 3, 18, 31, 14, 34, 30, 11, 9};
		assertEquals(5, new TreeAndVertex().get(tree));
	}
}
