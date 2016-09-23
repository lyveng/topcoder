import org.junit.Test;
import static org.junit.Assert.*;

public class PointDistanceTest {
	
	@Test(timeout=2000)
	public void test0() {
		int x1 = -1;
		int y1 = 0;
		int x2 = 1;
		int y2 = 0;
		assertArrayEquals(new int[] {8, 48 }, new PointDistance().findPoint(x1, y1, x2, y2));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int x1 = 1;
		int y1 = 1;
		int x2 = -1;
		int y2 = -1;
		assertArrayEquals(new int[] {25, -63 }, new PointDistance().findPoint(x1, y1, x2, y2));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int x1 = 0;
		int y1 = 1;
		int x2 = 2;
		int y2 = 3;
		assertArrayEquals(new int[] {41, 65 }, new PointDistance().findPoint(x1, y1, x2, y2));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int x1 = 5;
		int y1 = -4;
		int x2 = -2;
		int y2 = 5;
		assertArrayEquals(new int[] {68, 70 }, new PointDistance().findPoint(x1, y1, x2, y2));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int x1 = -50;
		int y1 = -50;
		int x2 = 50;
		int y2 = -50;
		assertArrayEquals(new int[] {67, 4 }, new PointDistance().findPoint(x1, y1, x2, y2));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int x1 = -50;
		int y1 = 50;
		int x2 = -49;
		int y2 = 49;
		assertArrayEquals(new int[] {73, -25 }, new PointDistance().findPoint(x1, y1, x2, y2));
	}
}
