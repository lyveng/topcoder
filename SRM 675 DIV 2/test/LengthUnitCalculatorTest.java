import org.junit.Test;
import static org.junit.Assert.*;

public class LengthUnitCalculatorTest {
	
	@Test(timeout=2000)
	public void test0() {
		int amount = 1;
		String fromUnit = "mi";
		String toUnit = "ft";
		assertEquals(5280.0, new LengthUnitCalculator().calc(amount, fromUnit, toUnit), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test1() {
		int amount = 1;
		String fromUnit = "ft";
		String toUnit = "mi";
		assertEquals(1.893939393939394E-4, new LengthUnitCalculator().calc(amount, fromUnit, toUnit), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test2() {
		int amount = 123;
		String fromUnit = "ft";
		String toUnit = "yd";
		assertEquals(41.0, new LengthUnitCalculator().calc(amount, fromUnit, toUnit), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test3() {
		int amount = 1000;
		String fromUnit = "mi";
		String toUnit = "in";
		assertEquals(6.336E7, new LengthUnitCalculator().calc(amount, fromUnit, toUnit), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test4() {
		int amount = 1;
		String fromUnit = "in";
		String toUnit = "mi";
		assertEquals(1.5782828282828283E-5, new LengthUnitCalculator().calc(amount, fromUnit, toUnit), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test5() {
		int amount = 47;
		String fromUnit = "mi";
		String toUnit = "mi";
		assertEquals(47.0, new LengthUnitCalculator().calc(amount, fromUnit, toUnit), 1e-9);
	}
}
