package srm631.division1;
/**
 * Level 1 problem.
 * 
 * @author emmanuel
 *
 */
public class CatsOnTheLineDiv1 {

  public int getNumber(int[] position, int[] count, int time) {
    int ret = 0;
    for (int i = 0; i < count.length; i++) {
      for (int j = i+1; j < count.length; j++) {
        if (position[i] > position[j]) {
          swap(position, i, j);
          swap(count, i, j);
        }
      }
    }
    int x = Integer.MIN_VALUE, f = Integer.MIN_VALUE;
    for (int i = 0; i < count.length; i++) {
      int a = Math.max(position[i] - time, x + 1);
      int b = position[i] + time;
      if (position[i] - time <= f) {
        // move all cats to f
      }
      else if (b - a + 1 >= count[i]) {
        x = a + count[i] - 1;
      }
      else {
        ret++;
        x = f = b;
      }
    }
    return ret;
  }

  void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
