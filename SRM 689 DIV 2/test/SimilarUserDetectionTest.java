import org.junit.Test;
import static org.junit.Assert.*;

public class SimilarUserDetectionTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] handles = new String[] {"top", "coder", "TOPCODER", "TOPC0DER"};
		assertEquals("Similar handles found", new SimilarUserDetection().haveSimilar(handles));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] handles = new String[] {"Topcoder", "topcoder", "t0pcoder", "topcOder"};
		assertEquals("Similar handles not found", new SimilarUserDetection().haveSimilar(handles));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] handles = new String[] {"same", "same", "same", "different"};
		assertEquals("Similar handles found", new SimilarUserDetection().haveSimilar(handles));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] handles = new String[] {"0123", "0I23", "0l23", "O123", "OI23", "Ol23"};
		assertEquals("Similar handles found", new SimilarUserDetection().haveSimilar(handles));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] handles = new String[] {"i23", "123", "456", "789", "000", "o", "O"};
		assertEquals("Similar handles not found", new SimilarUserDetection().haveSimilar(handles));
	}
}
