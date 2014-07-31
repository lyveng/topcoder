package srm150.division1;

/**
 * Level 2 Problem.
 * 
 * @author emmanuel
 * 
 */
public class StripePainter {
  int MAX_STROKE_SIZE = 51;
  int MAX_COLOR = 27;
  // minCount[i][j][color] gives minimum strokes required to finish from i to j inclusive when
  // current color of i to j is color.
  int[][][] minCount = new int[MAX_STROKE_SIZE][MAX_STROKE_SIZE][MAX_COLOR];

  private int getColor(char c) {
    return c - 'A';
  }

  public int minStrokes(String stripes) {
    return minStrokesUtil(stripes, 0, stripes.length() - 1, 26);
  }

  private int minStrokesUtil(String stripes, int start, int end, int currentColor) {
    if (start > end)
      return 0;
    if (minCount[start][end][currentColor] != 0)
      return minCount[start][end][currentColor];
    int minSum = Integer.MAX_VALUE, sum;
    if (getColor(stripes.charAt(start)) == currentColor) {
      minCount[start][end][currentColor] = minStrokesUtil(stripes, start + 1, end, currentColor);
      return minCount[start][end][currentColor];
    }
    for (int curEnd = start; curEnd <= end; curEnd++) {
      sum = 1 + minStrokesUtil(stripes, start, curEnd, getColor(stripes.charAt(start))) + minStrokesUtil(stripes, curEnd + 1, end, currentColor);
      if (sum < minSum)
        minSum = sum;
    }
    minCount[start][end][currentColor] = minSum;
    return minSum;
  }
}
