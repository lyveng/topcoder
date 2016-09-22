import org.junit.Test;
import static org.junit.Assert.*;

public class DNASequenceTest {
	
	@Test(timeout=2000)
	public void test0() {
		String sequence = "TOPBOATER";
		assertEquals(2, new DNASequence().longestDNASequence(sequence));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String sequence = "SUSHI";
		assertEquals(0, new DNASequence().longestDNASequence(sequence));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String sequence = "GATTACA";
		assertEquals(7, new DNASequence().longestDNASequence(sequence));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String sequence = "GOODLUCK";
		assertEquals(1, new DNASequence().longestDNASequence(sequence));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String sequence = "VVZWKCSIQEGANULDLZESHUYHUQGRKUMFCGTATGOHMLKBIRCA";
		assertEquals(6, new DNASequence().longestDNASequence(sequence));
	}
}
