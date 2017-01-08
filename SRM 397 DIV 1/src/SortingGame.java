import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class SortingGame {
	
	public int fewestMoves(int[] board, int k) {
		Map<Board, Integer> distTo = new HashMap<>();
		Queue<int[]> q = new LinkedList<>();
		q.add(board);
		distTo.put(new Board(board), 0);
		while (!q.isEmpty()) {
			int[] cur = q.remove();
			int d = distTo.get(new Board(cur));
			if (isSorted(cur))
				return d;
			for (int pos=0;pos+k<=board.length;pos++) {
				int[] newBoard = reverse(cur, pos, k);
				if (distTo.containsKey(new Board(newBoard)))
					continue;
				distTo.put(new Board(newBoard), d + 1);
				q.add(newBoard);
			}
		}

		return -1;
	}

	private int[] reverse(int[] board, int pos, int k) {
		int[] newBoard = Arrays.copyOf(board, board.length);
		for (int i=pos,j=1;i<pos+k;i++,j++) {
			newBoard[i] = board[pos+k-j];
		}
		return newBoard;
	}

	private boolean isSorted(int[] board) {
		for (int i=0;i<board.length-1;i++)
			if (board[i]>board[i+1])
				return false;
		return true;
	}

	public static class Board{
		int[] board;

		public Board(int[] board) {
			this.board = board;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Board board1 = (Board) o;

			return Arrays.equals(board, board1.board);

		}

		@Override
		public int hashCode() {
			return Arrays.hashCode(board);
		}
	}
}
