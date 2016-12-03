import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class FilipTheFrog {
	public int countReachableIslands(int[] positions, int L) {
		Queue<Integer> q = new LinkedList<>();
		q.add(positions[0]);
		int count = 1;
		boolean[] visited = new boolean[positions.length];
		visited[0] = true;
		while (!q.isEmpty()) {
			int curIsland = q.poll();
			for (int i=0;i<positions.length;i++) {
				if (visited[i])
					continue;
				if (positions[i] >= curIsland - L && positions[i] <= curIsland + L) {
					visited[i] = true;
					count++;
					q.add(positions[i]);
				}
			}
		}
		return count;
	}
}
