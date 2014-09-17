package srm195.division1;
import java.util.Arrays;

/**
 * Level 1 problem.
 * 
 * @author emmanuel
 *
 */
public class FanFailure {

  public int[] getRange(int[] capacities, int minCooling) {
    final int sum = sum(capacities);
    Arrays.sort(capacities);
    int curSum = 0, mfs = 0, mfc = 0;
    for (int i = 0; i < capacities.length; i++) {
      if (sum - (curSum + capacities[i]) < minCooling) {
        mfs = i;
        break;
      }
      curSum += capacities[i];
    }
    curSum = 0;
    for (int i = 0; i < capacities.length; i++) {
      if (curSum + capacities[i] >= minCooling) {
        mfc = capacities.length - i - 1;
        break;
      }
      curSum += capacities[i];
    }
    return new int[] {mfs, mfc};
  }

  int sum(int[] capacitites) {
    int sum = 0;
    for (int i = 0; i < capacitites.length; i++) {
      sum += capacitites[i];
    }
    return sum;
  }
}
