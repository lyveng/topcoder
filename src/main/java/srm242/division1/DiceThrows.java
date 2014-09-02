package srm242.division1;
public class DiceThrows {
  public static final int MAX_SUM = 20001;

  public double winProbability(int numDiceA, int[] sidesA, int numDiceB, int[] sidesB) {
    double[] probA = getProb(numDiceA, sidesA);
    double[] probB = getProb(numDiceB, sidesB);
    double ret = 0.;
    for (int i = 0; i < MAX_SUM; i++) {
      for (int j = 0; j < i; j++) {
        ret += probA[i]*probB[j];
      }
    }
    return ret;
  }

  private double[] getProb(int n, int[] sides) {
    double[] prob = new double[MAX_SUM];
    prob[0] = 1.0;
    for (int j = 0; j < n; j++) {
      for (int i = 20000; i >= 0; i--) {
        prob[i] = 0.;
        for (int k = 0; k < sides.length; k++) {
          if (i - sides[k] >= 0)
            prob[i] += (prob[i-sides[k]] / 6.);
        }
      }
    }
    return prob;
  }
}
