import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class PipeCuts {
	
	public double probability(int[] weldLocations, int L) {
		Arrays.sort(weldLocations);
		double x = 0;
		for (int i=0;i<weldLocations.length;i++) {
			for (int j=i+1;j<weldLocations.length;j++) {
				int a = weldLocations[i], b = weldLocations[j] - weldLocations[i], c = 100 - weldLocations[j];
				if (a > L || b > L || c > L)
					x+=1;
			}
		}
		return 2 * x / (weldLocations.length * (weldLocations.length-1));
	}
}
