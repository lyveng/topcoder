package srm234.division1;
import java.util.TreeSet;

public class WeirdRooks {
  private TreeSet<Pair> pairs;

  public String describe(int[] cols) {
    pairs = new TreeSet<>();
    boolean[] markedCols = new boolean[cols[cols.length-1]];
    describeUtil(cols, 0, 0, cols.length-1, markedCols);
    return getPairs();
  }

  private String getPairs() {
    StringBuilder sb = new StringBuilder();
    for (Pair p : pairs) {
      sb.append(p.r);
      sb.append(",");
      sb.append(p.f);
      sb.append(" ");
    }
    sb.deleteCharAt(sb.length()-1);
    return sb.toString();
  }

  private void describeUtil(int[] cols, int rookCount, int specialSquares, int curRow, boolean[] markedCols) {
    if (curRow == -1) {
      pairs.add(new Pair(rookCount, specialSquares));
      return;
    }
    // don't place a rook on the current row.
    int curRowSpecialSquareCount = 0;
    for (int i = 0; i < cols[curRow]; i++) {
      if (!markedCols[i])
        curRowSpecialSquareCount++;
    }
    describeUtil(cols, rookCount, specialSquares+curRowSpecialSquareCount, curRow-1, markedCols);

    // place a rook on the current row.
    for (int i = 0; i < cols[curRow]; i++) {
      if (markedCols[i])
        continue;
      markedCols[i] = true;
      curRowSpecialSquareCount = 0;
      for (int j = i+1; j < cols[curRow]; j++) {
        if (!markedCols[j])
          curRowSpecialSquareCount++;
      }
      describeUtil(cols, rookCount+1, specialSquares+curRowSpecialSquareCount, curRow-1, markedCols);
      markedCols[i] = false;
    }
  }

  class Pair implements Comparable<Pair>{
    Integer r, f;

    @Override
    public int compareTo(Pair o) {
      int rComp = r.compareTo(o.r);
      if (rComp != 0)
        return rComp;
      return f.compareTo(o.f);
    }

    public Pair(Integer r, Integer f) {
      super();
      this.r = r;
      this.f = f;
    }

    @Override
    public String toString() {
      return "Pair [r=" + r + ", f=" + f + "]";
    }
  }
}
