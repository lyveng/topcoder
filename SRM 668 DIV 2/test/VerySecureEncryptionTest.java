import org.junit.Test;
import static org.junit.Assert.*;

public class VerySecureEncryptionTest {
	
	@Test(timeout=2000)
	public void test0() {
		String message = "abc";
		int[] key = new int[] {1,2,0};
		int K = 1;
		assertEquals("cab", new VerySecureEncryption().encrypt(message, key, K));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String message = "abcde";
		int[] key = new int[] {4, 3, 2, 1, 0};
		int K = 1;
		assertEquals("edcba", new VerySecureEncryption().encrypt(message, key, K));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String message = "abcde";
		int[] key = new int[] {4, 3, 2, 1, 0};
		int K = 2;
		assertEquals("abcde", new VerySecureEncryption().encrypt(message, key, K));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String message = "uogcodlk";
		int[] key = new int[] {4, 3, 6, 2, 5, 1, 0, 7};
		int K = 44;
		assertEquals("goodluck", new VerySecureEncryption().encrypt(message, key, K));
	}
}
