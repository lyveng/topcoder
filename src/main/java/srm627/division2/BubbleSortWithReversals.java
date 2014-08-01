package srm627.division2;

/**
 * Level 3 Problem.
 * @author emmanuel
 *
 */
public class BubbleSortWithReversals {
  final int MAX_REVERSALS = 51;
  final int MAX_ELEMENTS = 51;
  int[][] dp = new int[MAX_ELEMENTS][MAX_REVERSALS];

  public int getMinSwaps(int[] A, int K) {
    for (int k = 0; k <= K; k++) {
      for (int start = A.length - 1; start >= 0; start--) {
        // element at start is not part of any reversal
        dp[start][k] = dp[start + 1][k] + getInversionCount(A, start, start);
        if (k > 0) {
          // start to end is reversed.
          for (int end = start + 1; end < A.length; end++) {
            reverse(A, start, end);
            dp[start][k] = Math.min(dp[start][k], dp[end + 1][k - 1] + getInversionCount(A, start, end));
            reverse(A, start, end);
          }
        }
      }
    }
    return dp[0][K];
  }

  private void reverse(int[] A, int start, int end) {
    while (start < end) {
      int tmp = A[start];
      A[start] = A[end];
      A[end] = tmp;
      start++;
      end--;
    }
  }

  /**
   * Fetches inversion count contributed by indices from start to end.
   * 
   * @param A
   * @param start
   * @return
   */
  private int getInversionCount(int[] A, int start, int end) {
    int count = 0;
    for (int curPos = start; curPos <= end; curPos++) {
      for (int i = 0; i < curPos; i++) {
        if (A[i] > A[curPos])
          count++;
      }
    }
    return count;
  }
}
