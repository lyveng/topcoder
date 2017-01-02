import org.junit.Test;
import static org.junit.Assert.*;

public class CostOfDancingTest {
	
	@Test(timeout=2000)
	public void test0() {
		int K = 2;
		int[] danceCost = new int[] {1, 5, 3, 4};
		assertEquals(4, new CostOfDancing().minimum(K, danceCost));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int K = 3;
		int[] danceCost = new int[] {1, 5, 4};
		assertEquals(10, new CostOfDancing().minimum(K, danceCost));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int K = 1;
		int[] danceCost = new int[] {2, 2, 4, 5, 3};
		assertEquals(2, new CostOfDancing().minimum(K, danceCost));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int K = 39;
		int[] danceCost = new int[] {973, 793, 722, 573, 521, 568, 845, 674, 595, 310, 284, 794, 913, 93, 129, 758, 108, 433, 181, 163, 96, 932,
 703, 989, 884, 420, 615, 991, 364, 657, 421, 336, 801, 142, 908, 321, 709, 752, 346, 656, 413, 629, 801};
		assertEquals(20431, new CostOfDancing().minimum(K, danceCost));
	}
}
