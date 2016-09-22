import org.junit.Test;
import static org.junit.Assert.*;

public class CoinFlipsDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		String state = "HT";
		assertEquals(2, new CoinFlipsDiv2().countCoins(state));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String state = "T";
		assertEquals(0, new CoinFlipsDiv2().countCoins(state));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String state = "HHH";
		assertEquals(0, new CoinFlipsDiv2().countCoins(state));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String state = "HHTHHH";
		assertEquals(3, new CoinFlipsDiv2().countCoins(state));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String state = "HHHTTTHHHTTTHTHTH";
		assertEquals(12, new CoinFlipsDiv2().countCoins(state));
	}
}
