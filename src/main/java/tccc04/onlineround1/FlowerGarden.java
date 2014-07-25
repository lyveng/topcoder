package tccc04.onlineround1;

/**
 * Division 1 Level 2 problem.
 * 
 * @author emmanuel
 * 
 */
public class FlowerGarden {

  public int[] getOrdering(final int[] height, final int[] bloom, final int[] wilt) {
    int[] ret = new int[height.length];
    boolean[] marked = new boolean[height.length];
    for (int i = 0; i < ret.length; i++) {
      int best = -1;
      outer: for (int j = 0; j < height.length; j++) {
        if (marked[j])
          continue;
        for (int k = 0; k < marked.length; k++) {
          if (marked[k])
            continue;
          if (j == k)
            continue;
          if (wilt[j] >= bloom[k] && bloom[j] <= wilt[k] && height[j] > height[k])
            continue outer;
        }
        if (best == -1 || height[j] > height[best])
          best = j;
      }
      ret[i] = height[best];
      marked[best] = true;
    }
    return ret;
  }

}
