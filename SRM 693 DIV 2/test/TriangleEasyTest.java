import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleEasyTest {
	
	@Test(timeout=2000)
	public void test0() {
		int n = 3;
		int[] x = new int[] {};
		int[] y = new int[] {};
		assertEquals(3, new TriangleEasy().find(n, x, y));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int n = 4;
		int[] x = new int[] {0,2,1,2};
		int[] y = new int[] {3,0,2,3};
		assertEquals(0, new TriangleEasy().find(n, x, y));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int n = 6;
		int[] x = new int[] {0,0,2};
		int[] y = new int[] {3,1,4};
		assertEquals(1, new TriangleEasy().find(n, x, y));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int n = 4;
		int[] x = new int[] {0,2};
		int[] y = new int[] {1,3};
		assertEquals(2, new TriangleEasy().find(n, x, y));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int n = 20;
		int[] x = new int[] {16,4,15,6,1,0,10,12,7,15,2,4,8,1,10,15,13,10,1,16,3,19,8,7,13,1,15,15,15,5,16,7,5,6,4,18,3,8,6,2,16,8,19,14,17,16,4,6,9,17,4,10,8,12,2,3,18,9,13,17,4,7,10,0,13,11,15,17,11,15,11,19,19,4,10,14,16,6,3,17,1,4,14,9,7,18,10,11,5,0,5,9,9,7,16,12,4,10,17,3};
		int[] y = new int[] {17,18,6,16,18,6,11,2,15,10,1,15,17,8,5,9,7,0,0,4,16,1,9,0,9,5,17,14,1,12,14,11,9,18,0,12,11,3,19,14,7,6,3,19,0,1,19,5,11,19,2,13,12,0,6,2,14,16,14,18,5,5,19,3,6,14,12,5,17,3,1,12,7,11,8,8,10,11,13,2,13,13,0,18,2,7,2,12,14,9,3,19,2,8,12,13,8,18,13,18};
		assertEquals(1, new TriangleEasy().find(n, x, y));
	}

	@Test(timeout=2000000000)
	public void test5() {
		int n = 50;
		int[] x = new int[] {26, 45, 7, 30, 8, 9, 38, 40, 44, 34, 29, 16, 12, 39, 0, 47, 27, 1, 22, 3, 18, 32, 19, 28};
		int[] y = new int[] {10, 21, 37, 31, 2, 13, 15, 48, 25, 42, 11, 36, 43, 41, 20, 6, 4, 14, 23, 24, 5, 33, 46, 35};
		assertEquals(2, new TriangleEasy().find(n, x, y));
	}
}
