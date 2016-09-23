import org.junit.Test;
import static org.junit.Assert.*;

public class RelationClassifierTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] domain = new int[] {1, 1};
		int[] range = new int[] {2, 3};
		assertEquals("Not", new RelationClassifier().isBijection(domain, range));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] domain = new int[] {4, 5};
		int[] range = new int[] {2, 2};
		assertEquals("Not", new RelationClassifier().isBijection(domain, range));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] domain = new int[] {1};
		int[] range = new int[] {2};
		assertEquals("Bijection", new RelationClassifier().isBijection(domain, range));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] domain = new int[] {1, 2, 3, 4, 5};
		int[] range = new int[] {1, 2, 3, 4, 5};
		assertEquals("Bijection", new RelationClassifier().isBijection(domain, range));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] domain = new int[] {14, 12, 10, 13, 20, 18, 9, 17, 14, 9};
		int[] range = new int[] {18, 6, 8, 15, 2, 14, 10, 13, 13, 15};
		assertEquals("Not", new RelationClassifier().isBijection(domain, range));
	}
}
