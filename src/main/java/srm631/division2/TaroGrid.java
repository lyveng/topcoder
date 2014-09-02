package srm631.division2;

/**
 * Level 1 problem.
 * 
 * @author emmanuel
 *
 */
public class TaroGrid {

  public int getNumber(String[] grid) {
    int maxCount=1;
    int cols = grid[0].length(), rows = grid.length;
    int count;
    char prev;
    for (int i = 0; i < cols; i++) {
      count = 1;
      prev = grid[0].charAt(i);
      for (int j = 1; j < rows; j++) {
        if (grid[j].charAt(i) == prev)
          count++;
        else {
          maxCount = Math.max(count, maxCount);
          prev = grid[j].charAt(i);
          count = 1;
        }
      }
      maxCount = Math.max(count, maxCount);
    }
    return maxCount;
  }

}
