import org.junit.Test;
import static org.junit.Assert.*;

public class CarolsSingingTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] lyrics = new String[] {"YN","NY"};
		assertEquals(2, new CarolsSinging().choose(lyrics));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] lyrics = new String[] {"YN","YY","YN"};
		assertEquals(1, new CarolsSinging().choose(lyrics));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] lyrics = new String[] {"YNN","YNY","YNY","NYY","NYY","NYN"};
		assertEquals(2, new CarolsSinging().choose(lyrics));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] lyrics = new String[] {"YNNYYY","YYNYYY","YNNYYN","NYYNNN","YYYNNN","YYYNNY","NYYYYY","NYNYYY","NNNNYY",
 "YYYYYY","YNNNNN","YYYYNY","YYNNNN","NNYYYN","NNNNYY","YYYNNN","NYNNYN","YNNYYN",
 "YYNNNY","NYYNNY","NNYYYN","YNYYYN","NNNYNY","YYYYNN","YYNYNN","NYYNYY","YYNYYN"};
		assertEquals(4, new CarolsSinging().choose(lyrics));
	}
}
