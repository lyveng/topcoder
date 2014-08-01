package tccc03.semifinals3;

/**
 * Level 1 problem.
 * @author emmanuel
 *
 */
public class ZigZag {

  public int longestZigZag(int[] sequence) {
    int[] inc = new int[sequence.length], dec = new int[sequence.length];
    for (int i = 0; i < sequence.length; i++) {
      inc[i] = 1;
      for (int j = 0; j < i; j++) {
        if (sequence[j] > sequence[i])
          inc[i] = Math.max(inc[i], 1 + dec[j]);
      }
      dec[i] = 1;
      for (int j = 0; j < i; j++) {
        if (sequence[j] < sequence[i])
          dec[i] = Math.max(dec[i], 1 + inc[j]);
      }
    }
    int max=Integer.MIN_VALUE;
    for (int i = 0; i < inc.length; i++)
      max = Math.max(max, Math.max(inc[i], dec[i]));
    return max;
  }

}
