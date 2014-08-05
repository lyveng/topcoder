package srm613.division2;

/*
 * Level 3 problem.
 */
public class TaroCards {
  private static final int MAX_CARD_SET = 1024;
  private static final int MAX_SINGLE_CARD_INTEGERS = 41;
  private static final int MAX_CARDS = 51;
  long[][][] dp = new long[MAX_CARD_SET][MAX_SINGLE_CARD_INTEGERS][MAX_CARDS];
  boolean[][][] visited = new boolean[MAX_CARD_SET][MAX_SINGLE_CARD_INTEGERS][MAX_CARDS];

  public long getNumber(int[] first, int[] second, int K) {
    return getNumberUtil(first, second, K, 0, 0, 0);
  }

  private long getNumberUtil(int[] first, int[] second, int K, int S, int r, int i) {
    if (visited[S][r][i])
      return dp[S][r][i];
    if (i == first.length) {
      dp[S][r][i] = (Integer.bitCount(S) + r) <= K ? 1 : 0;
      visited[S][r][i] = true;
      return dp[S][r][i];
    }
    visited[S][r][i] = true;
    // Don't pick card i
    dp[S][r][i] = getNumberUtil(first, second, K, S, r, i+1);
    // Pick card i
    int S1 = S, r1=r;
    
    if (first[i] < 11)
      S1 = S1 | (1 << (first[i]-1));
    else
      r1++;
    S1 = S1 | (1 << (second[i]-1));
    dp[S][r][i] += getNumberUtil(first, second, K, S1, r1, i+1);

    return dp[S][r][i];
  }
}
