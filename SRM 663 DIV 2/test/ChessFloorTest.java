import org.junit.Test;
import static org.junit.Assert.*;

public class ChessFloorTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] floor = new String[] {"aba",
 "bbb",
 "aba"}
;
		assertEquals(1, new ChessFloor().minimumChanges(floor));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] floor = new String[] {"wbwbwbwb",
 "bwbwbwbw",
 "wbwbwbwb",
 "bwbwbwbw",
 "wbwbwbwb",
 "bwbwbwbw",
 "wbwbwbwb",
 "bwbwbwbw"}
 ;
		assertEquals(0, new ChessFloor().minimumChanges(floor));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] floor = new String[] {"zz",
 "zz"};
		assertEquals(2, new ChessFloor().minimumChanges(floor));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] floor = new String[] {"helloand",
 "welcomet",
 "osingler",
 "oundmatc",
 "hsixhund",
 "redandsi",
 "xtythree",
 "goodluck"};
		assertEquals(56, new ChessFloor().minimumChanges(floor));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] floor = new String[] {"jecjxsengslsmeijrmcx",
 "tcfyhumjcvgkafhhffed",
 "icmgxrlalmhnwwdhqerc",
 "xzrhzbgjgabanfxgabed",
 "fpcooilmwqixfagfojjq",
 "xzrzztidmchxrvrsszii",
 "swnwnrchxujxsknuqdkg",
 "rnvzvcxrukeidojlakcy",
 "kbagitjdrxawtnykrivw",
 "towgkjctgelhpomvywyb",
 "ucgqrhqntqvncargnhhv",
 "mhvwsgvfqgfxktzobetn",
 "fabxcmzbbyblxxmjcaib",
 "wpiwnrdqdixharhjeqwt",
 "xfgulejzvfgvkkuyngdn",
 "kedsalkounuaudmyqggb",
 "gvleogefcsxfkyiraabn",
 "tssjsmhzozbcsqqbebqw",
 "ksbfjoirwlmnoyyqpbvm",
 "phzsdodppzfjjmzocnge"};
		assertEquals(376, new ChessFloor().minimumChanges(floor));
	}
}
