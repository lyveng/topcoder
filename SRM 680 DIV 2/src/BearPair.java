import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class BearPair {
	
	public int bigDistance(String s) {
		int max = -1, cur;
		for (int i=s.length() - 1; i >= 0; i--) {
			cur = -1;
			for (int j=0;j<i;j++) {
				if (s.charAt(j) != s.charAt(i)) {
					cur = i - j;
					if (cur > max)
						max = cur;
					break;
				}
			}
		}
		return max;
	}
}
