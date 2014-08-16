package srm174.division1;
public class PointSystem {
  private static final int MAX_SCORE = 2001;
  double[][] dp = new double[MAX_SCORE][MAX_SCORE];

  public double oddsOfWinning(int pointsToWin, int pointsToWinBy, int skill) {
    double skillPercent = skill / 100.;
    dp[0][0] = 1.0;
    double ret = 0;
    for (int games = 0; games < 2000; games++) {
      for (int underdog = 0; underdog <= games; underdog++) {
        int favorite = games - underdog;
        if (favorite >= pointsToWin && favorite - underdog >= pointsToWinBy)
          continue;
        if (underdog >= pointsToWin && underdog - favorite >= pointsToWinBy) {
          ret += dp[underdog][favorite];
          continue;
        }
        dp[underdog+1][favorite] += skillPercent * dp[underdog][favorite];
        dp[underdog][favorite+1] += (1.0 - skillPercent) * dp[underdog][favorite];
      }
    }
    return ret;
  }
}
