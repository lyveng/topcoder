import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ArcadeManao {
	
	public int shortestLadder(String[] level, int coinRow, int coinColumn) {
		for (int length = 0; length<level.length - coinRow;length++) {
			boolean[][] marked = new boolean[level.length][level[0].length()];
			dfs(marked, level, coinRow-1,coinColumn-1, level.length-1, 0, length);
			if (marked[coinRow-1][coinColumn-1])
				return length;
		}
		return level.length-coinRow;
	}

	private void dfs(boolean[][] marked, String[] level, int coinRow, int coinColumn, int row, int column, int ladderLength) {
		marked[row][column] = true;
		if (row == coinRow && column == coinColumn)
			return;
		// Move left
		if (column - 1 >= 0 && level[row].charAt(column-1) == 'X' && !marked[row][column-1]) {
			dfs(marked, level, coinRow, coinColumn, row, column-1, ladderLength);
		}

		// Move right
		if (column + 1 < level[0].length() && level[row].charAt(column+1) == 'X' && !marked[row][column+1])
			dfs(marked, level, coinRow, coinColumn, row, column+1, ladderLength);

		for (int delta=1;delta<=ladderLength;delta++) {
			// Move up
			if (row - delta >= 0 && level[row-delta].charAt(column) == 'X' && !marked[row-delta][column])
				dfs(marked, level, coinRow, coinColumn, row-delta, column, ladderLength);

			// Move down
			if (row + delta < level.length && level[row+delta].charAt(column) == 'X' && !marked[row+delta][column])
				dfs(marked, level, coinRow, coinColumn, row+delta, column, ladderLength);
		}
	}
}
