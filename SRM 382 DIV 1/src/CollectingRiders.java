import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class CollectingRiders {
	
	public int minimalMoves(String[] board) {
		int m=board.length, n = board[0].length();
		int[][] moves = new int[][] {{1,2}, {1,-2}, {2,1}, {2,-1}, {-1,2}, {-1,-2}, {-2,1}, {-2,-1}};
		List<KnightMoves> allDist = new ArrayList<>(board.length*board[0].length());
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length(); j++) {
				if (board[i].charAt(j) == '.')
					continue;
				int[][] dist = new int[board.length][board[0].length()];
				boolean[][] marked = new boolean[board.length][board[0].length()];
				Queue<Vertex> q = new LinkedList<>();
				q.add(new Vertex(i, j));
				marked[i][j] = true;
				while (!q.isEmpty()) {
					Vertex cur = q.poll();
					for (int[] move : moves) {
						int u = cur.u + move[0], v = cur.v + move[1];
						if (u < 0 || u >= m || v < 0 || v >= n || marked[u][v])
							continue;
						marked[u][v] = true;
						q.add(new Vertex(u, v));
						dist[u][v] = dist[cur.u][cur.v] + 1;
					}
				}
				allDist.add(new KnightMoves(i, j, dist, marked));
			}
		}
		boolean fails = true;
		boolean[][] allMarked = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				allMarked[i][j] = true;
				for (KnightMoves k:allDist) {
					if (!k.marked[i][j]) {
						allMarked[i][j] = false;
						break;
					}
				}
				if (allMarked[i][j])
					fails=false;
			}
		}

		if (fails)
			return -1;

		int[][] dist = new int[m][n];
		for (KnightMoves k : allDist) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					int d = board[k.u].charAt(k.v) - '0';
					dist[i][j] += Math.ceil(((double)k.dist[i][j]) / d);
				}
			}
		}
		int minVal=Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!allMarked[i][j])
					continue;
				minVal = Math.min(minVal, dist[i][j]);
			}
		}
		return minVal;
	}

	public class Vertex {
		int u, v;

		public Vertex(int u, int v) {
			this.u = u;
			this.v = v;
		}
	}

	public class KnightMoves extends Vertex {
		int[][] dist;
		boolean[][] marked;

		public KnightMoves(int u, int v, int[][] dist, boolean[][] marked) {
			super(u, v);
			this.dist = dist;
			this.marked = marked;
		}
	}
}
