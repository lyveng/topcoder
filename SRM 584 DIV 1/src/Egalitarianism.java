import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Egalitarianism {
	
	public int maxDifference(String[] isFriend, int d) {
		int retVal = 0;
		for (int source=0;source<isFriend.length;source++) {
			int[] distTo = new int[isFriend.length];
			boolean[] marked = new boolean[isFriend.length];
			Queue<Integer> q = new LinkedList<>();
			q.add(source);
			marked[source] = true;
			int maxDist = 0;
			while (!q.isEmpty()) {
				int u = q.poll();
				for (int v = 0; v < isFriend.length; v++) {
					if (isFriend[u].charAt(v) == 'N' || marked[v])
						continue;
					distTo[v] = distTo[u] + d;
					maxDist = distTo[v];
					marked[v] = true;
					q.add(v);
				}
			}
			for (int i = 0; i < marked.length; i++)
				if (!marked[i])
					return -1;

			retVal = Math.max(retVal, maxDist);
		}
		return retVal;
	}
}
