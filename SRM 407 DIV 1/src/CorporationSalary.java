import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class CorporationSalary {
	
	public long totalSalary(String[] relations) {
		long[] salary = new long[relations.length];
		List<Integer>[] adj = new List[relations.length];
		for(int i=0;i<relations.length;i++) {
			adj[i] = new LinkedList<>();
			for (int j=0;j<relations.length;j++) {
				if (relations[i].charAt(j) == 'Y')
					adj[i].add(j);
			}
		}

		List<Integer> order = new LinkedList<>();
		boolean[] marked = new boolean[relations.length];
		for (int i=0;i<relations.length;i++) {
			if (!marked[i])
				dfs(i, adj, marked, order);
		}

		Collections.reverse(order);
		marked = new boolean[relations.length];
		for (int i : order) {
			marked[i] = true;
			calculateSalary(i, adj, marked, salary);
		}
		long retVal = 0;
		for (long s : salary)
			retVal += s;
		return retVal;
	}

	private void calculateSalary(int u, List<Integer>[] adj, boolean[] marked, long[] salary) {
		if (adj[u].isEmpty())
			salary[u] = 1;
		else
			salary[u] = 0;
 		for (int v : adj[u]) {
			if (!marked[v]) {
				marked[v] = true;
				calculateSalary(v, adj, marked, salary);
			}
			salary[u] += salary[v];
		}
	}

	private void dfs(int u, List<Integer>[] adj, boolean[] marked, List<Integer> order) {
		for (int v : adj[u]) {
			if (!marked[v]) {
				marked[v] = true;
				dfs(v, adj, marked, order);
			}
		}
		order.add(u);
	}
}
