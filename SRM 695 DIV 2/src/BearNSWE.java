import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class BearNSWE {
	public double totalDistance(int[] a, String dir) {
		Map<Character, Integer[]> dirMap = new HashMap<>();
		dirMap.put('N', new Integer[] {0, 1});
		dirMap.put('S', new Integer[] {0, -1});
		dirMap.put('E', new Integer[] {1, 0});
		dirMap.put('W', new Integer[] {-1, 0});

		int curX=0, curY=0;
		double totalDist = 0;
		for (int i=0;i<a.length;i++) {
			totalDist += a[i];
			curX += dirMap.get(dir.charAt(i))[0] * a[i];
			curY += dirMap.get(dir.charAt(i))[1] * a[i];
		}
		return Math.sqrt(curX*curX + curY*curY) + totalDist;
	}
}
