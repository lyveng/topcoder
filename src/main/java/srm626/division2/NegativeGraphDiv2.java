package srm626.division2;

/**
 * Level 3 problem.
 * 
 * @author emmanuel
 *
 */
public class NegativeGraphDiv2 {
  private static int MAX_DIST = 1000000000;

  public long findMin(int N, int[] s, int[] t, int[] weight, int charges) {
    int[][] dist = new int[N][N];
    for (int i = 0; i < dist.length; i++) {
      for (int j = 0; j < dist[i].length; j++) {
        dist[i][j] = MAX_DIST;
      }
      dist[i][i] = 0;
    }
    for (int i = 0; i < s.length; i++) {
      int u = s[i] - 1, v = t[i] - 1, w = weight[i];
      dist[u][v] = Math.min(dist[u][v], w);
    }
    for (int k = 0; k < N; k++)
      for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
    int[][] levelMinDistToN = new int[charges + 1][N];
    for (int i = 0; i < N; i++) {
      levelMinDistToN[0][i] = dist[i][N - 1];
    }
    for (int curCharges = 1; curCharges <= charges; curCharges++) {
      for (int curNode = 0; curNode < N; curNode++) {
        levelMinDistToN[curCharges][curNode] = levelMinDistToN[curCharges - 1][curNode];

        for (int i = 0; i < weight.length; i++) {
          int u = s[i] - 1, v = t[i] - 1, w = -weight[i];
          levelMinDistToN[curCharges][curNode] =
              Math.min(levelMinDistToN[curCharges][curNode], dist[curNode][u] + w + levelMinDistToN[curCharges - 1][v]);
        }
      }
    }
    return levelMinDistToN[charges][0];
  }
}
