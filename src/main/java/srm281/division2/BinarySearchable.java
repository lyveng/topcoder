package srm281.division2;

/**
 * Level 3 problem.
 * 
 * @author emmanuel
 *
 */
public class BinarySearchable {

  public int howMany(int[] sequence) {
    boolean[] left = new boolean[sequence.length], right = new boolean[sequence.length];
    for (int i = 0; i < sequence.length; i++) {
      for (int j = 0; j < i; j++) {
        if (sequence[j] > sequence[i]) {
          left[i] = true;
          break;
        }
      }
      for (int j = i+1; j < sequence.length; j++) {
        if (sequence[j] < sequence[i]) {
          right[i] = true;
          break;
        }
      }
    }
    int count = 0;
    for (int i = 0; i < sequence.length; i++) {
      if (!left[i] && !right[i])
        count++;
    }
    return count;
  }

}
