import org.junit.Test;
import static org.junit.Assert.*;

public class EgalitarianismTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] isFriend = new String[] {"NYN",
 "YNY",
 "NYN"};
		int d = 10;
		assertEquals(20, new Egalitarianism().maxDifference(isFriend, d));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] isFriend = new String[] {"NN",
 "NN"};
		int d = 1;
		assertEquals(-1, new Egalitarianism().maxDifference(isFriend, d));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] isFriend = new String[] {"NNYNNN",
 "NNYNNN",
 "YYNYNN",
 "NNYNYY",
 "NNNYNN",
 "NNNYNN"};
		int d = 1000;
		assertEquals(3000, new Egalitarianism().maxDifference(isFriend, d));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] isFriend = new String[] {"NNYN",
 "NNNY",
 "YNNN",
 "NYNN"};
		int d = 584;
		assertEquals(-1, new Egalitarianism().maxDifference(isFriend, d));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] isFriend = new String[] {"NYNYYYN",
 "YNNYYYN",
 "NNNNYNN",
 "YYNNYYN",
 "YYYYNNN",
 "YYNYNNY",
 "NNNNNYN"};
		int d = 5;
		assertEquals(20, new Egalitarianism().maxDifference(isFriend, d));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String[] isFriend = new String[] {"NYYNNNNYYYYNNNN",
 "YNNNYNNNNNNYYNN",
 "YNNYNYNNNNYNNNN",
 "NNYNNYNNNNNNNNN",
 "NYNNNNYNNYNNNNN",
 "NNYYNNYNNYNNNYN",
 "NNNNYYNNYNNNNNN",
 "YNNNNNNNNNYNNNN",
 "YNNNNNYNNNNNYNN",
 "YNNNYYNNNNNNNNY",
 "YNYNNNNYNNNNNNN",
 "NYNNNNNNNNNNNNY",
 "NYNNNNNNYNNNNYN",
 "NNNNNYNNNNNNYNN",
 "NNNNNNNNNYNYNNN"}
;
		int d = 747;
		assertEquals(2988, new Egalitarianism().maxDifference(isFriend, d));
	}
	
	@Test(timeout=2000)
	public void test6() {
		String[] isFriend = new String[] {"NY",
 "YN"};
		int d = 0;
		assertEquals(0, new Egalitarianism().maxDifference(isFriend, d));
	}
}
