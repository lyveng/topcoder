package tccc04.onlineround1;
public class RockSkipping {
  final int MAX_DIST = 11000;

  public double probability(String pads, int maxDist) {
    double[] dp = new double[MAX_DIST];
    dp[0] = 1;
    for (int dist = maxDist; dist > 0; dist--) {
      for (int pos = MAX_DIST-1; pos >= 0; pos--) {
        dp[pos] = 0.;
        if (pads.charAt(pos % pads.length()) == 'X')
          continue;
        for (int jump = 1; jump <= dist; jump++) {
          if (pos - jump >= 0)
            dp[pos] += (dp[pos-jump]*1./dist);
        }
      }
    }
    double ret = 0.;
    for (int i = 0; i < dp.length; i++) {
      ret += dp[i];
    }
    return ret*100;
  }

}
