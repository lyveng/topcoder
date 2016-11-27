import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Xylophone {
	
	public int countKeys(int[] keys) {
		int[] count = new int[] {0,0,0,0,0,0,0};
		for (int key : keys) {
			count[(key-1) % 7]++;
		}
		int ret = 0;
		for (int c : count) {
			if (c > 0)
				ret++;
		}
		return ret;
	}
}
