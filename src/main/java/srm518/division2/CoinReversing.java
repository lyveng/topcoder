package srm518.division2;

/**
 * Level 3 problem.
 * 
 * @author emmanuel
 *
 */
public class CoinReversing {
  public double expectedHeads(int N, int[] a) {
    double p, q = 1;
    for (int cur_a : a) {
      p = (double) cur_a / (double) N;
      q = p*(1-q) + (1-p)*q;
    }
    return q*N;
  }

}
