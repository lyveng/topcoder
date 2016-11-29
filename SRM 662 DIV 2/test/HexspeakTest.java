import org.junit.Test;
import static org.junit.Assert.*;

public class HexspeakTest {
	
	@Test(timeout=2000)
	public void test0() {
		long ciphertext = 257L;
		assertEquals("IOI", new Hexspeak().decode(ciphertext));
	}
	
	@Test(timeout=2000)
	public void test1() {
		long ciphertext = 258L;
		assertEquals("Error!", new Hexspeak().decode(ciphertext));
	}
	
	@Test(timeout=2000)
	public void test2() {
		long ciphertext = 3405691582L;
		assertEquals("CAFEBABE", new Hexspeak().decode(ciphertext));
	}
	
	@Test(timeout=2000)
	public void test3() {
		long ciphertext = 2882400001L;
		assertEquals("ABCDEFOI", new Hexspeak().decode(ciphertext));
	}
	
	@Test(timeout=2000)
	public void test4() {
		long ciphertext = 999994830345994239L;
		assertEquals("DEOBIFFFFFFFFFF", new Hexspeak().decode(ciphertext));
	}
	
	@Test(timeout=2000)
	public void test5() {
		long ciphertext = 1000000000000000000L;
		assertEquals("Error!", new Hexspeak().decode(ciphertext));
	}
}
