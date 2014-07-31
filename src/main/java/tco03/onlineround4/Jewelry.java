package tco03.onlineround4;
import java.util.Arrays;

public class Jewelry {
  // Maximum sum that can be formed.
  int MAX_SUM = 30000;
  // Maximum no of jewelery items.
  int MAX_ELEMENT = 30;
  // cache for the binmoial coefficient n choose k.
  long[][] comb = new long[MAX_ELEMENT + 1][MAX_ELEMENT + 1];

  public long howMany(int[] values) {
    Arrays.sort(values);
    long ret = 0;
    int groupSize = 1;
    for (int i = 0; i < values.length - 1; i += groupSize) {
      long[] waysBelow = getSumWays(Arrays.copyOfRange(values, 0, i));
      groupSize = 1;
      for (int j = i + 1; j < values.length; j++) {
        if (values[j] != values[i])
          break;
        groupSize++;
      }
      for (int g = 0; g < groupSize; g++) {
        long[] waysAbove = getSumWays(Arrays.copyOfRange(values, i + g + 1, values.length));
        for (int s = values[i] * (g + 1); s <= MAX_SUM; s++) {
          ret += (comb(groupSize, g + 1) * waysBelow[s - values[i]*(g+1)] * waysAbove[s]);
        }
      }
    }
    return ret;
  }

  long[] getSumWays(int[] values) {
    int maxSum = sum(values);
    long[] ways = new long[MAX_SUM + 1];
    ways[0] = 1;
    for (int i = 0; i < values.length; i++) {
      for (int j = maxSum; j >= values[i]; j--) {
        ways[j] += ways[j - values[i]];
      }
    }
    return ways;
  }

  int sum(int[] values) {
    int sum = 0;
    for (int i = 0; i < values.length; i++) {
      sum += values[i];
    }
    return sum;
  }

  long comb(int n, int k) {
    if (comb[n][k] > 0)
      return comb[n][k];
    if (k == 0 || n == k)
      return 1;
    comb[n][k] = comb(n - 1, k - 1) + comb(n - 1, k);
    return comb[n][k];
  }

  public static void main(String[] args) {
    Jewelry j = new Jewelry();
    System.out.println(j.comb(5, 2));
  }
}
