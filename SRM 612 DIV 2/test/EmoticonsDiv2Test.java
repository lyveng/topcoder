import org.junit.Test;
import static org.junit.Assert.*;

public class EmoticonsDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		int smiles = 2;
		assertEquals(2, new EmoticonsDiv2().printSmiles(smiles));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int smiles = 6;
		assertEquals(5, new EmoticonsDiv2().printSmiles(smiles));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int smiles = 11;
		assertEquals(11, new EmoticonsDiv2().printSmiles(smiles));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int smiles = 16;
		assertEquals(8, new EmoticonsDiv2().printSmiles(smiles));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int smiles = 1000;
		assertEquals(21, new EmoticonsDiv2().printSmiles(smiles));
	}
}
