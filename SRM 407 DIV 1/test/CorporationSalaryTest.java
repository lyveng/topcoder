import org.junit.Test;
import static org.junit.Assert.*;

public class CorporationSalaryTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] relations = new String[] {"N"};
		assertEquals(1L, new CorporationSalary().totalSalary(relations));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] relations = new String[] {"NNYN",
 "NNYN",
 "NNNN",
 "NYYN"};
		assertEquals(5L, new CorporationSalary().totalSalary(relations));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] relations = new String[] {"NNNNNN",
 "YNYNNY",
 "YNNNNY",
 "NNNNNN",
 "YNYNNN",
 "YNNYNN"};
		assertEquals(17L, new CorporationSalary().totalSalary(relations));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] relations = new String[] {"NYNNYN",
 "NNNNNN",
 "NNNNNN",
 "NNYNNN",
 "NNNNNN",
 "NNNYYN"};
		assertEquals(8L, new CorporationSalary().totalSalary(relations));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] relations = new String[] {"NNNN",
 "NNNN",
 "NNNN",
 "NNNN"};
		assertEquals(4L, new CorporationSalary().totalSalary(relations));
	}
}
