package srm610.division2;
import java.util.Arrays;

public class MiningGoldEasy {
  final int MAX_EVENTS = 51;
  int[][][] dp = new int[MAX_EVENTS][MAX_EVENTS][MAX_EVENTS];
  int N, M, t;
  int[] event_i, event_j;

  public int GetMaximumGold(int N, int M, int[] event_i, int[] event_j) {
    this.t = event_i.length;
    this.N = N;
    this.M = M;
    this.event_i = event_i;
    this.event_j = event_j;
    for (int i = 0; i < MAX_EVENTS; i++) {
      for (int j = 0; j < MAX_EVENTS; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < event_i.length; i++) {
      for (int j = 0; j < event_j.length; j++) {
        max = Math.max(max, f(i, j, 0));
      }
    }
    return max;
  }

  private int f(int a, int b, int s) {
    if (dp[a][b][s] != -1)
      return dp[a][b][s];
    if (s == t)
      return 0;
    int profit = N + M - Math.abs(event_i[a] - event_i[s]) - Math.abs(event_j[b] - event_j[s]);
    dp[a][b][s] = 0;
    for (int i = 0; i < t; i++) {
      dp[a][b][s] = Math.max(dp[a][b][s], profit + f(i, b, s + 1));
    }
    for (int i = 0; i < t; i++) {
      dp[a][b][s] = Math.max(dp[a][b][s], profit + f(a, i, s + 1));
    }
    return dp[a][b][s];
  }
}
