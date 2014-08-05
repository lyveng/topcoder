package srm223.divsion1;
/**
 * Level 1 problem.
 * 
 * @author emmanuel
 * 
 */
public class QuizShow {

  public int wager(int[] scores, int wager1, int wager2) {
    int[] moves = {1, -1};
    int bestWager = 0, odds, bestOdds = 0;
    for (int wager = 0; wager <= scores[0]; wager++) {
      odds = 0;
      for (int a : moves) {
        for (int b : moves) {
          for (int c : moves) {
            if (((a * wager + scores[0]) > (b * wager1 + scores[1])) && ((a * wager + scores[0]) > (c * wager2 + scores[2])))
              odds++;

          }
        }
      }
      if (odds > bestOdds) {
        bestWager = wager;
        bestOdds = odds;
      }
    }
    return bestWager;
  }

}
