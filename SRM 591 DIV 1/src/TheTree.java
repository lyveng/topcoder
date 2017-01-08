import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class TheTree {
	
	public int maximumDiameter(int[] cnt) {



		int curNode = 0;
		int size = 1;
		for (int c : cnt)
			size += c;
		Graph g = new Graph(size);
		List<Integer>[] levels = new List[cnt.length+1];
		for (int i=0;i<levels.length;i++) {
			levels[i] = new LinkedList<>();
		}
		levels[0].add(curNode++);
		for (int i=0;i<cnt.length;i++) {
			int parent = 0;
			for (int j=0;j<cnt[i];j++) {
				int u = levels[i].get(parent++ % levels[i].size());
				int v = curNode++;
				g.addEdge(u, v);
				levels[i+1].add(v);
			}
		}

		int retVal = Integer.MIN_VALUE;
		for (int i:levels[cnt.length]) {
			retVal = Math.max(longestPath(g, i), retVal);
		}
		return retVal;
	}

	public int longestPath(Graph g, int source) {
		int[] distTo = new int[g.V];
		boolean[] marked = new boolean[g.V];
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		marked[source] = true;
		while (!q.isEmpty()) {
			int u = q.poll();
			for (int v : g.adj[u]) {
				if (!marked[v]) {
					distTo[v] = distTo[u]+1;
					marked[v] = true;
					q.add(v);
				}
			}
		}
		int maxDist = Integer.MIN_VALUE;
		for (int i=0;i<distTo.length;i++) {
			maxDist = Math.max(distTo[i], maxDist);
		}
		return maxDist;
	}

	public class Graph {
		int V;
		List<Integer>[] adj;

		public Graph(int v) {
			V = v;
			adj = new List[v];
			for (int i=0;i<v;i++)
				adj[i] = new LinkedList<>();
		}

		public void addEdge(int u, int v) {
			adj[u].add(v);
			adj[v].add(u);
		}
	}
}
