import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class TriangleEasy {
	
	public int find(int n, int[] x, int[] y) {
		// Construct graph adjacency list
		List<Integer>[] adj = new List[n];
		for (int i=0;i<n;i++)
			adj[i] = new LinkedList<>();
		for (int i=0;i<x.length;i++) {
			adj[x[i]].add(y[i]);
			adj[y[i]].add(x[i]);
		}

		// Calculate connected component sizes using dfs
		// Detect cycles using dfs and check if the length of the cycle is 3
		boolean[] marked = new boolean[n];
		int[] edgeTo = new int[n];
		int ccsize=0, maxccsize=0;
		Stack<Entry> s = new Stack<>();
		for (int i=0;i<n;i++) {
			if (marked[i])
				continue;
			ccsize=0;
			s.push(new Entry(i, i));
			while (!s.empty()) {
				Entry u = s.pop();
				marked[u.u] = true;
				ccsize++;
				for (int v:adj[u.u]) {
					if (marked[v]) {
						if (v != u.v) {
							// cycle exists. find the length of the cycle
							int cur = u.u;
							int cycleSize = 1;
							// The 2nd condition is to prevent the looping infinitely as there might be some cases where there is a cycle like the following
							// 1->2->3->4->1 with 4->2 also as an edge. u = 4, v = 1. the below code will loop infinitely in 2->3->4->2
							while (cur != v && cycleSize <= 3) {
								cur = edgeTo[cur];
								cycleSize++;
							}
							if (cycleSize == 3)
								return 0;
						}
						continue;
					}
					edgeTo[v] = u.u;
					s.push(new Entry(v, u.u));
				}
			}
			maxccsize = ccsize > maxccsize ? ccsize : maxccsize;
		}

		if (maxccsize == 1)
			return 3;
		else if (maxccsize == 2)
			return 2;
		return 1;
	}

	public class Entry {
		int u, v;

		public Entry(int u, int v) {
			this.u = u;
			this.v = v;
		}
	}
}
