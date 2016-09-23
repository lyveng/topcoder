import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class LiveConcert {
	
	public int maxHappiness(int[] h, String[] s) {
		boolean[] done = new boolean[101];
		int ret = 0, max;
		for (int i=0;i<s.length;i++) {
			if (done[i])
				continue;
			done[i] = true;
			max = h[i];
			for (int j=i+1;j<s.length;j++) {
				if (s[j].equals(s[i])) {
					done[j] = true;
					if (h[j] > max)
						max = h[j];
				}
			}
			ret += max;
		}
		return ret;
	}
}
