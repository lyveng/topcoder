package srm620.division2;

import java.util.Arrays;

/**
 * Level 1 Problem.
 * 
 * @author emmanuel
 *
 */
public class CandidatesSelectionEasy {
  public int[] sort(String[] score, int x) {
    Maid[] maids = new Maid[score.length];
    for (int i=0;i<score.length;i++)
    {
      maids[i] = new Maid(i, score[i].charAt(x));
    }
    Arrays.sort(maids);
    int[] ret = new int[score.length];
    for (int i=0;i<score.length;i++)
      ret[i] = maids[i].id;
    return ret;
  }

  private static class Maid implements Comparable<Maid> {
    int id;
    Character score;
    @Override
    public int compareTo(Maid o) {
      return score.compareTo(o.score);
    }
    Maid(int id, Character score) {
      super();
      this.id = id;
      this.score = score;
    }
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
