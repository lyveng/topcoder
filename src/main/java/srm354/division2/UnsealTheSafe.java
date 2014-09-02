package srm354.division2;
import java.util.Arrays;

/**
 * Level 3 problem.
 * 
 * @author emmanuel
 *
 */
public class UnsealTheSafe {
  private static int MAX_DIGIT = 10;
  private static int MAX_LENGTH = 51;
  // dp[i][j] gives no of passwords starting with i of length j
  long[][] dp = new long[MAX_DIGIT][MAX_LENGTH];
  int[][] adj = {{7}, {2,4}, {1,5,3}, {2,6}, {1,5,7}, {2,4,8,6}, {3,5,9}, {0,4,8}, {5,7,9}, {6,8}};

  public long countPasswords(int N) {
    for (long[] arr : dp) {
      Arrays.fill(arr, -1);
    }
    long ret=0;
    for (int i = 0; i < 10; i++) {
      ret += f(i, N-1);
    }
    return ret;
  }

  private long f(int d, int n) {
    if (dp[d][n] != -1)
      return dp[d][n];
    if (n == 0)
      return dp[d][n] = 1;
    dp[d][n] = 0;
    for (int next_d : adj[d]) {
      dp[d][n] += f(next_d, n-1);
    }
    return dp[d][n];
  }
}
