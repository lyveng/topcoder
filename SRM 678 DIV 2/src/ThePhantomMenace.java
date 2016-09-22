import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ThePhantomMenace {
	
	public int find(int[] doors, int[] droids) {
		int max=-1, safety;
		for (int i=0;i<doors.length;i++) {
			safety = Math.abs(doors[i] - droids[0]);
			for (int j=1;j<droids.length;j++) {
				if (Math.abs(doors[i] - droids[j]) < safety)
					safety = Math.abs(doors[i] - droids[j]);
			}
			if (safety > max)
				max = safety;
		}
		return max;
	}
}
