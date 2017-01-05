import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Fragile2 {
	
	public int countPairs(String[] graph) {
		int count=0;
		int ccCount = countCC(graph, new HashSet<>());
		for (int u=0;u < graph.length;u++) {
			for (int v=u+1;v < graph.length;v++) {
				String[] newGraph = Arrays.copyOf(graph, graph.length);
				Set<Integer> excludedVertices = new HashSet<>(2);
				excludedVertices.add(u);
				excludedVertices.add(v);
				int newCCCount = countCC(newGraph, excludedVertices);
				if (newCCCount > ccCount)
					count++;
			}
		}
		return count;
	}

	public int countCC(String[] graph, Set<Integer> excludedVertices) {
		int count = 0;
		boolean[] marked = new boolean[graph.length];
		Stack<Integer> s = new Stack<>();
		for (int i=0;i<graph.length;i++) {
			if (excludedVertices.contains(i) || marked[i])
				continue;
			s.push(i);
			count++;
			while (!s.empty()) {
				int u = s.pop();
				if (marked[u])
					continue;
				marked[u] = true;
				for (int v=0;v<graph.length;v++) {
					if (excludedVertices.contains(v) || marked[v] || graph[u].charAt(v) == 'N')
						continue;
					s.push(v);
				}
			}
		}
		return count;
	}
}
