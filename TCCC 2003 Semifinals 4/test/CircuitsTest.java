import org.junit.Test;
import static org.junit.Assert.*;

public class CircuitsTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] connects = new String[] {"1 2",
 "2",
 ""};
		String[] costs = new String[] {"5 3",
 "7",
 ""};
		assertEquals(12, new Circuits().howLong(connects, costs));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] connects = new String[] {"1 2 3 4 5","2 3 4 5","3 4 5","4 5","5",""};
		String[] costs = new String[] {"2 2 2 2 2","2 2 2 2","2 2 2","2 2","2",""};
		assertEquals(10, new Circuits().howLong(connects, costs));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] connects = new String[] {"1","2","3","","5","6","7",""};
		String[] costs = new String[] {"2","2","2","","3","3","3",""};
		assertEquals(9, new Circuits().howLong(connects, costs));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] connects = new String[] {"","2 3 5","4 5","5 6","7","7 8","8 9","10",
 "10 11 12","11","12","12",""};
		String[] costs = new String[] {"","3 2 9","2 4","6 9","3","1 2","1 2","5",
 "5 6 9","2","5","3",""};
		assertEquals(22, new Circuits().howLong(connects, costs));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] connects = new String[] {"","2 3","3 4 5","4 6","5 6","7","5 7",""};
		String[] costs = new String[] {"","30 50","19 6 40","12 10","35 23","8","11 20",""};
		assertEquals(105, new Circuits().howLong(connects, costs));
	}
}
