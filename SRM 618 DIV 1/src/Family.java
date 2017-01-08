import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Family {
	
	public String isFamily(int[] parent1, int[] parent2) {
		List<Integer>[] adj = new List[parent1.length];
		for (int i=0;i<parent1.length;i++) {
			adj[i] = new LinkedList<>();
			if (parent1[i] == -1)
				continue;
			adj[parent1[i]].add(parent2[i]);
			adj[parent2[i]].add(parent1[i]);
		}
		boolean[] marked = new boolean[parent1.length];
		boolean[] color = new boolean[parent1.length];
		for (int i=0;i<parent1.length;i++)
			if (!marked[i]) {
				try {
					dfs(adj, marked, color, i);
				} catch (NotFamilyException e) {
					return "Impossible";
				}
			}
		return "Possible";
	}

	public class NotFamilyException extends Exception {
	}

	private void dfs(List<Integer>[] adj, boolean[] marked, boolean[] color, int u) throws  NotFamilyException {
		marked[u] = true;
		for (int v : adj[u]) {
			if (!marked[v]) {
				color[v] = !color[u];
				dfs(adj, marked, color, v);
			}
			else if (color[v] == color[u])
				throw new NotFamilyException();
		}
	}
}
