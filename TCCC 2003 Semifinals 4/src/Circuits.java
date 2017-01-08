import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Circuits {
	
	public int howLong(String[] connects, String[] costs) {
		Graph g = new Graph(connects.length);
		for (int u=0;u<connects.length;u++) {
			if (connects[u] == "")
				continue;
			String[] adj = connects[u].split(" ");
			String[] edgeCosts = costs[u].split(" ");
			for (int i=0;i<adj.length;i++) {
				if (adj[i] == "")
					continue;
				int v = Integer.parseInt(adj[i]);
				int weight = Integer.parseInt(edgeCosts[i]);
				g.addEdge(u, v, weight);
			}
		}

		// Compute topological order
		Stack<Integer> order = new Stack<>();
		boolean[] marked = new boolean[g.V];
		for (int i=0;i<g.V;i++)
			if (!marked[i])
				dfs(g, i, order, marked);
		Collections.reverse(order);

		int maxDist = 0;
		for (int u=0;u < g.V;u++) {
			maxDist = Math.max(maxDist, longestPath(g, u, order));
		}
		return maxDist;
	}

	private void dfs(Graph g, int u, Stack<Integer> order, boolean[] marked) {
		marked[u] = true;
		for (Edge e : g.adj[u]) {
			if (!marked[e.v])
				dfs(g, e.v, order, marked);
		}
		order.push(u);
	}

	private int longestPath(Graph g, int source, List<Integer> order) {
		double[] distTo = new double[g.V];
		distTo[source] = 0;
		for (int i=0;i<g.V;i++) {
			if (i == source)
				continue;
			distTo[i] = Double.NEGATIVE_INFINITY;
		}

		for (int u : order) {
			relax(g, u, distTo);
		}
		double maxDist = distTo[0];
		for (int i=1;i<g.V;i++)
			if (distTo[i] > maxDist)
				maxDist = distTo[i];
		return (int)maxDist;
	}

	private void relax(Graph g, int u, double[] distTo) {
		for (Edge e : g.adj[u]) {
			if (distTo[e.v] < distTo[e.u] + e.weight) {
				distTo[e.v] = distTo[e.u] + e.weight;
			}
		}
	}

	public class Graph {
		int V;
		List<Edge>[] adj;

		public Graph(int v) {
			V = v;
			adj = new List[v];
			for (int i=0;i<v;i++)
				adj[i] = new LinkedList<>();
		}

		public void addEdge(int u, int v, int weight) {
			adj[u].add(new Edge(u, v, weight));
		}
	}

	public class Edge {
		int u, v, weight;

		public Edge(int u, int v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
	}
}
