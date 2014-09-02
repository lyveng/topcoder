package tccc05.qualset5;
import java.util.Arrays;

public class NestedRandomness {
  final int MAX_NESTINGS = 11;
  final int MAX_N = 1001;
  double[][] dp = new double[MAX_NESTINGS][MAX_N];

  public double probability(int N, int nestings, int target) {
    Arrays.fill(dp[1], 1./N);
    for (int curNesting = 2; curNesting <= nestings; curNesting++) {
      for (int curTarget = 0; curTarget <= N; curTarget++) {
        dp[curNesting][curTarget] = 0;
        for (int prevNestingTarget = curTarget+1; prevNestingTarget < N; prevNestingTarget++) {
          dp[curNesting][curTarget] += (dp[curNesting-1][prevNestingTarget] * 1. / prevNestingTarget);
        }
      }
    }
    for (int i = 0; i <= nestings; i++) {
      System.out.println(Arrays.toString(Arrays.copyOfRange(dp[i], 0, N+1)));
    }
    return dp[nestings][target];
  }

}
