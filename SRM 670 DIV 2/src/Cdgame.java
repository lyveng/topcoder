import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Cdgame {
	
	public int rescount(int[] a, int[] b) {
		long aSum = 0, bSum = 0;
		for (int i=0;i<a.length;i++) {
			aSum += a[i];
			bSum += b[i];
		}
		Set<Long> x = new TreeSet<>();
		for (int i=0;i<a.length;i++) {
			for (int j=0;j<b.length;j++) {
				x.add((aSum - a[i] + b[j]) * (bSum - b[j] + a[i]));
			}
		}
		return x.size();
	}
}
