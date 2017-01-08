import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ChristmasTreeDecoration {
	
	public int solve(int[] col, int[] x, int[] y) {
		boolean[] marked = new boolean[col.length];
		EdgeWeightedGraph g = new EdgeWeightedGraph(col.length);
		for (int i=0;i<x.length;i++) {
			int u = x[i]-1, v = y[i]-1;
			int weight = col[u] == col[v] ? 1 : 0;
			g.addEdge(new WeightedEdge(u, v, weight));
		}

		PriorityQueue<WeightedEdge> pq = new PriorityQueue<>();
		int ret = 0;
		visit(g, 0, marked, pq);
		while (!pq.isEmpty()) {
			WeightedEdge e = pq.poll();
			int u = e.either(), v= e.other(u);
			if (marked[u] && marked[v])
				continue;
			if (e.weight == 1)
				ret++;
			if (!marked[u])
				visit(g, u, marked, pq);
			if (!marked[v])
				visit(g, v, marked, pq);
		}
		return ret;
	}

	public void visit(EdgeWeightedGraph g, int u, boolean[] marked, PriorityQueue<WeightedEdge> pq) {
		marked[u] = true;
		for (WeightedEdge e : g.adj[u]) {
			if (!marked[e.other(u)])
				pq.add(e);
		}
	}

	public class WeightedEdge implements Comparable<WeightedEdge> {
		public int u, v, weight;

		public WeightedEdge(int u, int v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}

		public int either() {
			return u;
		}

		public int other(int u) {
			if (u == this.u)
				return this.v;
			else if (u == this.v)
				return this.u;
			throw new RuntimeException("Invalid vertex passwed to Edge.other");
		}

		@Override
		public int compareTo(WeightedEdge o) {
			return this.weight - o.weight;
		}
	}

	public class EdgeWeightedGraph {
		public int V;
		public List<WeightedEdge>[] adj;

		public EdgeWeightedGraph(int v) {
			V = v;
			adj = new List[v];
			for (int i=0;i<v;i++)
				adj[i] = new LinkedList<>();
		}

		public void addEdge(WeightedEdge e) {
			adj[e.either()].add(e);
			adj[e.other(e.either())].add(e);
		}
	}
}
