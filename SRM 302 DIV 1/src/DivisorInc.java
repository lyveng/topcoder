import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class DivisorInc {
	
	public int countOperations(int N, int M) {
		if (M == N)
			return 0;
		boolean[] marked = new boolean[M+1];
		int[] edgeTo = new int[M+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		marked[N] = true;
		edgeTo[N] = N;
		boolean done = false;
		while (!q.isEmpty()) {
			int u = q.poll();
			for (int d : divisors(u)) {
				int v = u + d;
				if (v > M || marked[v])
					continue;
				edgeTo[v] = u;
				marked[v] = true;
				q.add(v);
				if (v == M) {
					done = true;
					break;
				}
			}
			if (done)
				break;
		}
		if (!done)
			return -1;
		int length = 0, cur = M;
		while (cur != N) {
			cur = edgeTo[cur];
			length++;
		}
		return length;
	}

	private List<Integer> divisors(int x) {
		List<Integer> ret = new LinkedList<>();
		for (int i=2;i<=Math.sqrt(x);i++) {
			if (x % i == 0) {
				ret.add(i);
				int y = x / i;
				if (y != x)
					ret.add(y);
			}
		}
		return ret;
	}
}
