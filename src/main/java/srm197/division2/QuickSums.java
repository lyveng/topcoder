package srm197.division2;

/**
 * Level 3 problem.
 * 
 * @author emmanuel
 *
 */
public class QuickSums {
  int MAX_LENGTH = 11;
  int MAX_SUM = 101;
  int[][][] dp = new int[MAX_LENGTH][MAX_LENGTH][MAX_SUM];
  long[][] sum = new long[MAX_LENGTH][MAX_LENGTH];
  int minAdditions = Integer.MAX_VALUE;

  public int minSums(String numbers, int sum) {
    populateSum(numbers.toCharArray());
    boolean[] additionPosition = new boolean[numbers.length()];
    additionPosition[numbers.length() - 1] = true;
    minSumsUtil(numbers.toCharArray(), additionPosition, 0, sum, 0);
    return minAdditions == Integer.MAX_VALUE ? -1 : minAdditions;
  }

  private void minSumsUtil(char[] numbers, boolean[] additionPosition, int currentPosition, int sum, int additionCount) {
    if (currentPosition == additionPosition.length - 1) {
      long value = getValue(numbers, additionPosition);
      if (value == sum && additionCount < minAdditions)
        minAdditions = additionCount;
      return;
    }
    minSumsUtil(numbers, additionPosition, currentPosition + 1, sum, additionCount);
    additionPosition[currentPosition] = true;
    minSumsUtil(numbers, additionPosition, currentPosition + 1, sum, additionCount + 1);
    additionPosition[currentPosition] = false;
  }

  private long getValue(char[] numbers, boolean[] additionPosition) {
    int start = 0;
    long value = 0;
    for (int i = 0; i < additionPosition.length; i++) {
      if (additionPosition[i]) {
        value += sum[start][i];
        start = i + 1;
      }
    }
    if (start < numbers.length)
      value += sum[start][numbers.length - 1];
    return value;
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
