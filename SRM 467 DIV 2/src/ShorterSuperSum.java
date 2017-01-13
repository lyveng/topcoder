import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ShorterSuperSum {
	
	public int calculate(int k, int n) {
		int[][] dyn = new int[15][15];
		for (int i = 1; i <= n; i++) {
			dyn[0][i] = i;
		}
		for (int ki = 1; ki <= k; ki++) {
			for (int ni = 1; ni <= n; ni++) {
				dyn[ki][ni] = 0;
				for (int mi = 1; mi <= ni; mi++) {
					dyn[ki][ni] += dyn[ki-1][mi];
				}
			}
		}
		return dyn[k][n];
	}
}
