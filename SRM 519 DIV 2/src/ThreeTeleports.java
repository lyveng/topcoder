import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ThreeTeleports {
	// 0 - xMe, yMe
	// 1 - xHome, yHome
	// 2 - x1, y1 of teleport 1
	// 3 - x2, y2 of teleport 1
	// 4 ...
	// 7 - x2, y2 f teleport 3
	public int shortestDistance(int xMe, int yMe, int xHome, int yHome, String[] teleports) {
		int[] x = new int[8];
		int[] y = new int[8];
		x[0] = xMe;
		x[1] = xHome;
		y[0] = yMe;
		y[1] = yHome;
		for (int i=0;i<teleports.length;i++) {
			String[] coordinates = teleports[i].split(" ");
			int node1 = 2+i*2, node2 = 2+i*2+1;
			x[node1]=Integer.parseInt(coordinates[0]); y[node1]=Integer.parseInt(coordinates[1]);
			x[node2]=Integer.parseInt(coordinates[2]); y[node2]=Integer.parseInt(coordinates[3]);
		}

		long[] distTo = new long[8];
		int[] edgeTo = new int[8];
		distTo[0] = 0;
		for (int i=1;i<8;i++) {
			distTo[i] = Long.MAX_VALUE;
		}
		boolean[] marked = new boolean[8];
		int markedCount = 0;
		while (markedCount != 8) {
			int u = nextNode(marked, distTo);
			if (u == 1)
				break;
			marked[u] = true;
			markedCount++;
			for (int v=0;v<8;v++) {
				if (v == u)
					continue;
				long tempDist = distTo[u] + dist(x, y, u, v);
				if (tempDist < distTo[v]) {
					distTo[v] = tempDist;
					edgeTo[v] = u;
				}
			}
		}
		int retVal = (int) distTo[1];
		return retVal;
	}

	private int nextNode(boolean[] marked, long[] distTo) {
		int minIndex = -1;
		long minValue = Long.MAX_VALUE;
		for (int i=0;i<marked.length;i++) {
			if (marked[i])
				continue;
			if (distTo[i] < minValue) {
				minIndex = i;
				minValue = distTo[i];
			}
		}
		if (minIndex == -1)
			throw new NoSuchElementException();
		return minIndex;
	}

	private long dist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}

	private long dist(int[] x, int[] y, int u, int v) {
		int p = Math.min(u,v), q = Math.max(u,v);
		if ((p==2 && q==3) || (p==4 && q==5) || (p==6 && q==7))
			return 10;
		return dist(x[u], y[u], x[v], y[v]);
	}
}
