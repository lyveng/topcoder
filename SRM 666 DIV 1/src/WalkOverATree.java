import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class WalkOverATree {
	
	public int maxNodesVisited(int[] parent, int L) {
		int maxD = 0;
		for (int i=0;i<parent.length;i++) {
			int d = 1, cur=i;
			while (parent[cur] != 0) {
				d++;
				cur = parent[cur] - 1;
			}
			maxD = Math.max(maxD, d);
		}
		if (maxD >= L) {
			return L + 1;
		}
		return Math.min(parent.length+1, 1 + maxD + (L-maxD)/2);
	}
}
