import org.junit.Test;
import static org.junit.Assert.*;

public class ColorfulRoadTest {
	
	@Test(timeout=2000)
	public void test0() {
		String road = "RGGGB";
		assertEquals(8, new ColorfulRoad().getMin(road));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String road = "RGBRGBRGB";
		assertEquals(8, new ColorfulRoad().getMin(road));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String road = "RBBGGGRR";
		assertEquals(-1, new ColorfulRoad().getMin(road));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String road = "RBRRBGGGBBBBR";
		assertEquals(50, new ColorfulRoad().getMin(road));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String road = "RG";
		assertEquals(1, new ColorfulRoad().getMin(road));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String road = "RBRGBGBGGBGRGGG";
		assertEquals(52, new ColorfulRoad().getMin(road));
	}
}
