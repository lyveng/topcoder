package srm234.division1;

import java.util.TreeSet;


/**
 * Level 2 Problem.
 * 
 * @author emmanuel
 * 
 */
public class WeirdRooks {
  public String describe(int[] cols) {
    StringBuilder d = new StringBuilder();
    TreeSet<Pair> set = new TreeSet<WeirdRooks.Pair>();
    int maxCol = cols[0], totalSquares = cols[0];
    for (int i = 1; i < cols.length; i++) {
      if (cols[i] > maxCol)
        maxCol = cols[i];
      totalSquares += cols[i];
    }

    boolean[][] board = new boolean[cols.length][maxCol];
    for (int rooks = 0; rooks <= totalSquares; rooks++) {
      describeUtil(cols, 0, 0, board, rooks, totalSquares, set, rooks);
    }
    for (Pair p : set)
      d.append(String.format("%d,%d ", p.r, p.f));
    if (d.length() > 0)
      d.deleteCharAt(d.length()-1);
    return d.toString();
  }

  private void describeUtil(int[] cols, int row, int col, boolean[][] board, int remainingRookCount, int remainingSquares, TreeSet<Pair> set,
      int totalRookCount) {
    int nextRow = row, nextCol = col + 1;
    if (nextCol == cols[row]) {
      nextRow++;
      nextCol = 0;
    }

    if (remainingRookCount == 0) {
      set.add(new Pair(totalRookCount, getSpecialSquares(cols, board)));
      return;
    }

    if (nextRow >= cols.length) {
      if (remainingRookCount == 1 && isSafe(cols, row, col, board)) {
        board[row][col] = true;
        set.add(new Pair(totalRookCount, getSpecialSquares(cols, board)));
        board[row][col] = false;
      }
      return;
    }

    if (remainingRookCount > remainingSquares)
      return;

    // Don't place a rook at row, col
    describeUtil(cols, nextRow, nextCol, board, remainingRookCount, remainingSquares - 1, set, totalRookCount);

    // Place a rook at row, col
    if (isSafe(cols, row, col, board)) {
      board[row][col] = true;
      describeUtil(cols, nextRow, nextCol, board, remainingRookCount - 1, remainingSquares - 1, set, totalRookCount);
      board[row][col] = false;
    }
  }

  private boolean isSafe(int[] cols, int row, int col, boolean[][] board) {
    for (int i = 0; i < board[0].length; i++)
      if (board[row][i])
        return false;
    for (int i = 0; i < board.length; i++)
      if (board[i][col])
        return false;
    return true;
  }

  private int getSpecialSquares(int[] cols, boolean[][] board) {
    int count = 0;
    for (int row = 0; row < cols.length; row++) {
      for (int col = cols[row] - 1; col >= 0; col--) {
        if (isSpecial(board, row, col))
          count++;
        if (board[row][col])
          break;
      }
    }
    return count;
  }

  private boolean isSpecial(boolean[][] board, int row, int col) {
    for (int i = col; i < board[0].length; i++)
      if (board[row][i])
        return false;
    for (int i = row; i < board.length; i++)
      if (board[i][col])
        return false;
    return true;
  }

  private static class Pair implements Comparable<Pair>{
    Integer r, f;

    public Pair(Integer r, Integer f) {
      super();
      this.r = r;
      this.f = f;
    }

    @Override
    public int compareTo(Pair o) {
      if (r.compareTo(o.r) != 0)
        return r.compareTo(o.r);
      if (f.compareTo(o.f) != 0)
        return f.compareTo(o.f);
      return 0;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((f == null) ? 0 : f.hashCode());
      result = prime * result + ((r == null) ? 0 : r.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Pair other = (Pair) obj;
      if (f == null) {
        if (other.f != null)
          return false;
      } else if (!f.equals(other.f))
        return false;
      if (r == null) {
        if (other.r != null)
          return false;
      } else if (!r.equals(other.r))
        return false;
      return true;
    }
  }

  public static void main(String[] args) {
    WeirdRooks obj = new WeirdRooks();
    System.out.println(obj.describe(new int[] {3, 3, 3}));
  }

}
