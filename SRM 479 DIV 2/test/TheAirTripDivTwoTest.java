import org.junit.Test;
import static org.junit.Assert.*;

public class TheAirTripDivTwoTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] flights = new int[] {1, 2, 3, 4, 5, 6, 7};
		int fuel = 10;
		assertEquals(4, new TheAirTripDivTwo().find(flights, fuel));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] flights = new int[] {7, 6, 5, 4, 3, 2, 1};
		int fuel = 10;
		assertEquals(1, new TheAirTripDivTwo().find(flights, fuel));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] flights = new int[] {1};
		int fuel = 1000;
		assertEquals(1, new TheAirTripDivTwo().find(flights, fuel));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] flights = new int[] {8, 7, 7, 1, 5, 7, 9};
		int fuel = 21;
		assertEquals(2, new TheAirTripDivTwo().find(flights, fuel));
	}
}
