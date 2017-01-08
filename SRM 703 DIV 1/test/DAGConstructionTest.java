import org.junit.Test;
import static org.junit.Assert.*;

public class DAGConstructionTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] x = new int[] {2, 1};
		assertArrayEquals(new int[] {0, 1 }, new DAGConstruction().construct(x));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] x = new int[] {1, 1};
		assertArrayEquals(new int[] { }, new DAGConstruction().construct(x));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] x = new int[] {1, 3, 1};
		assertArrayEquals(new int[] {1, 0, 1, 2 }, new DAGConstruction().construct(x));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] x = new int[] {5,5,5,5,5};
		assertArrayEquals(new int[] {-1 }, new DAGConstruction().construct(x));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] x = new int[] {4,2,2,1};
		assertArrayEquals(new int[] {0, 1, 0, 2, 1, 3, 2, 3 }, new DAGConstruction().construct(x));
	}
}
