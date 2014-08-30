package tco04.onlineround3;
import java.util.Arrays;

public class Volleyball {
  static final int MAX_GAMES = 2000;
  private double[][] dp = new double[MAX_GAMES][MAX_GAMES];
  double p = 0.;

  public double win(int sScore, int rScore, double probWinServe) {
    this.p = probWinServe;
    for (int i = 0; i < MAX_GAMES; i++) {
      Arrays.fill(dp[i], -1);
    }
    return winUtil(sScore, rScore);
  }

  private double winUtil(int server, int nonserver) {
    if (server >= 1000 || nonserver >= 1000) return 0;
    if (dp[server][nonserver] != -1) return dp[server][nonserver];
    if (server >= 15 && server >= nonserver + 2)
      return 1;
    if (nonserver >= 15 && nonserver >= server + 2)
      return 0;
    double ret = p*winUtil(server+1, nonserver) + (1-p)*(1 - winUtil(nonserver+1, server));
    dp[server][nonserver] = ret;
    return ret;
  }
}
