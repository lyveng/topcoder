package srm197.division2;

import java.util.Arrays;

/**
 * Level 3 problem.
 * 
 * @author emmanuel
 * 
 */
public class QuickSumsDP {
  int MAX_LENGTH = 11;
  // Indicates maximum additions. Used for checking not possible conditions.
  int MAX_ADDITIONS = 11;
  int MAX_SUM = 101;
  int[][][] dp = new int[MAX_LENGTH][MAX_LENGTH][MAX_SUM];
  long[][] sum = new long[MAX_LENGTH][MAX_LENGTH];
  int minAdditions = Integer.MAX_VALUE;

  public int minSums(String numbers, int sum) {
    minSumsUtil(numbers.toCharArray(), sum);
    return dp[0][numbers.length()-1][sum] == MAX_ADDITIONS ? -1 : dp[0][numbers.length()-1][sum];
  }

  private void initialize(char[] numbers, int sum) {
    populateSum(numbers);
    // Fill all elements of dp with MAX_ADDITIONS
    for (int i = 0; i < MAX_LENGTH; i++) {
      for (int[] j : dp[i]) {
        Arrays.fill(j, MAX_ADDITIONS);
      }
    }
    for (int start = 0; start < numbers.length; start++) {
      for (int end = start; end < numbers.length; end++) {
        long num = this.sum[start][end];
        if (num < sum)
          dp[start][end][(int) num] = 0;
      }
    }
  }

  private void minSumsUtil(char[] numbers, int sum) {
    initialize(numbers, sum);
    for (int size = 2; size < numbers.length; size++) {
      for (int start = 0; start + size < numbers.length; start++) {
        int end = start + size;
        for (int curSum = 0; curSum <= sum; curSum++) {
          // Addition operator is placed after addPosition
          for (int addPosition = start; addPosition < end; addPosition++) {
            for (int leftSum = 0; curSum - leftSum >= 0; leftSum++) {
              int rightSum = curSum - leftSum;
              dp[start][end][curSum] = Math.min(dp[start][end][curSum], 1 + dp[start][addPosition][leftSum] + dp[addPosition + 1][end][rightSum]);
            }
          }
        }
      }
    }
  }

  private void populateSum(char[] numbers) {
    for (int start = 0; start < numbers.length; start++) {
      for (int end = start; end < numbers.length; end++) {
        sum[start][end] = getLongSum(numbers, start, end);
      }
    }
  }

  private long getLongSum(char[] numbers, int start, int end) {
    long sum = 0;
    for (int i = start; i <= end; i++) {
      sum = sum * 10 + (numbers[i] - '0');
    }
    return sum;
  }
}
