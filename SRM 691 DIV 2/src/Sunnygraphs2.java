import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Sunnygraphs2 {
	
	public long count(int[] a) {
		long c = 0;
		int cycleSum = 0;
		boolean[] marked = new boolean[a.length];
		ArrayList<Integer>  cycles = new ArrayList<>();
		for (int i=0;i<a.length;i++) {
			if (marked[i])
				continue;
			int y = a[i];
			boolean foundCycle = false;
			for (int j=0;j<a.length;j++) {
				if (y == i) {
					foundCycle = true;
					break;
				}
				y = a[y];
			}

			if (!foundCycle)
				continue;
			int cycleLength = 1;
			y = a[i];
			marked[i] = true;
			while (y != i) {
				marked[y] = true;
				cycleLength++;
				y = a[y];
			}
			cycleSum += cycleLength;
			cycles.add(cycleLength);
		}
		c = 1L << (a.length - cycleSum);
		for (int cycleLength : cycles) {
			c *= ((1L << cycleLength) - 1);
		}
		if (cycles.size() == 1)
			c += 1;
		return c;
	}
}
