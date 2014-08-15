package tccc05.round1;
import java.util.Arrays;

public class ChessKnight {
  private static final int MAX_N = 101;
  private static final int MAX_DIM = 9;
  double[][][] dp = new double[MAX_N][MAX_DIM][MAX_DIM];

  public double probability(int x, int y, int n) {
    for (int i = 0; i < MAX_DIM; i++) {
      Arrays.fill(dp[0][i], 1.0);
    }
    int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
    for (int curN = 1; curN <= n; curN++) {
      for (int curX = 1; curX < MAX_DIM; curX++) {
        for (int curY = 1; curY < MAX_DIM; curY++) {
          double prob = 0;
          for (int i = 0; i < dx.length; i++) {
            int nextX = curX + dx[i];
            int nextY = curY + dy[i];
            if (nextX > 0 && nextX < MAX_DIM && nextY > 0 && nextY < MAX_DIM)
              prob += (0.125 * dp[curN-1][nextX][nextY]);
          }
          dp[curN][curX][curY] = prob;
        }
      }
    }
    return dp[n][x][y];
  }

}
