package srm609.division2;

import java.util.Arrays;

/**
 * Level 3 problem.
 * 
 * @author emmanuel
 * 
 */
public class VocaloidsAndSongs {
  final int MAX_SONGS = 51;
  final int MOD = 1000000007;
  int[][][][] dp = new int[MAX_SONGS][MAX_SONGS][MAX_SONGS][MAX_SONGS];
  int s;

  public int count(int S, int gumi, int ia, int mayu) {
    for (int i = 0; i < MAX_SONGS; i++) {
      for (int j = 0; j < MAX_SONGS; j++) {
        for (int k = 0; k < MAX_SONGS; k++) {
          Arrays.fill(dp[i][j][k], -1);
        }
      }
    }
    this.s = S;
    return f(0, gumi, ia, mayu);
  }

  private int f(int s, int g, int i, int m) {
    if (dp[s][g][i][m] != -1)
      return dp[s][g][i][m];
    if (s == this.s && g == 0 && i == 0 && m == 0)
      dp[s][g][i][m] = 1;
    else if ((s == this.s) || (g == 0 && i == 0 && m == 0))
      dp[s][g][i][m] = 0;
    else {
      dp[s][g][i][m] = 0;
      if (g > 0)
        dp[s][g][i][m] = (dp[s][g][i][m] + f(s + 1, g - 1, i, m)) % MOD;
      if (i > 0)
        dp[s][g][i][m] = (dp[s][g][i][m] + f(s + 1, g, i - 1, m)) % MOD;
      if (m > 0)
        dp[s][g][i][m] = (dp[s][g][i][m] + f(s + 1, g, i, m - 1)) % MOD;
      if (g > 0 && i > 0)
        dp[s][g][i][m] = (dp[s][g][i][m] + f(s + 1, g - 1, i - 1, m)) % MOD;
      if (g > 0 && m > 0)
        dp[s][g][i][m] = (dp[s][g][i][m] + f(s + 1, g - 1, i, m - 1)) % MOD;
      if (i > 0 && m > 0)
        dp[s][g][i][m] = (dp[s][g][i][m] + f(s + 1, g, i - 1, m - 1)) % MOD;
      if (g > 0 && i > 0 && m > 0)
        dp[s][g][i][m] = (dp[s][g][i][m] + f(s + 1, g - 1, i - 1, m - 1)) % MOD;
    }
    return dp[s][g][i][m];

  }
}
