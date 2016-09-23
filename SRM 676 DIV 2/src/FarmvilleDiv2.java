import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class FarmvilleDiv2 {
	
	public int minTime(int[] time, int[] cost, int budget) {
		for (int i=0;i<cost.length;i++) {
			int min = i;
			for (int j=i+1;j<cost.length;j++) {
				if (cost[j] < cost[min])
					min = j;
			}
			swap(time, cost, i, min);
		}

		for (int i=0;i<cost.length;i++) {
			if (cost[i]*time[i] <= budget) {
				budget -= cost[i]*time[i];
				time[i] = 0;
			} else {
				int x = budget / cost[i];
				time[i] -= x;
				break;
			}
		}

		int s= 0;
		for (int i=0;i<time.length;i++) {
			s+= time[i];
		}
 		return s;
	}

	void swap(int[] time, int[] cost, int i, int j) {
		if (i == j)
			return;
		int t = time[i];
		time[i] = time[j];
		time[j] = t;
		t = cost[i];
		cost[i] = cost[j];
		cost[j] = t;
	}
}
