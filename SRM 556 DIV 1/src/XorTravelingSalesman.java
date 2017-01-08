import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class XorTravelingSalesman {
	
	public int maxProfit(int[] cityValues, String[] roads) {
		boolean[] marked = new boolean[1024*51];
		marked[cityValues[0]] = true;
		Stack<Node> s = new Stack<>();
		s.push(new Node(0, cityValues[0]));
		int maxP = cityValues[0];
		while (!s.empty()) {
			Node cur = s.pop();
			int u = cur.u;
			maxP = Math.max(maxP, cur.profit);
			for (int v=0;v<cityValues.length;v++) {
				if (roads[u].charAt(v) == 'N')
					continue;
				int profit = cur.profit^cityValues[v];
				int pos = v*1024+(profit);
				if (marked[pos])
					continue;
				marked[pos] = true;
				s.push(new Node(v, profit));
			}
		}
		return maxP;
	}

	public class Node {
		int u, profit;

		public Node(int u, int profit) {
			this.u = u;
			this.profit = profit;
		}
	}
}
