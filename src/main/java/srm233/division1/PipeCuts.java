package srm233.division1;
import java.util.Arrays;

/**
 * Level 1 problem.
 * 
 * @author emmanuel
 *
 */
public class PipeCuts {

  public double probability(int[] weldLocations, int L) {
    Arrays.sort(weldLocations);
    int total = weldLocations.length * (weldLocations.length-1) / 2, count = 0;
    for (int loc1 = 0; loc1 < weldLocations.length; loc1++) {
      for (int loc2 = loc1+1; loc2 < weldLocations.length; loc2++) {
        if (weldLocations[loc1] > L || weldLocations[loc2] - weldLocations[loc1] > L || 100 - weldLocations[loc2] > L)
          count++;
      }
    }
    return (double) count / (double) total;
  }

}
