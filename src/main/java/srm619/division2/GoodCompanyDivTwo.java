package srm619.division2;

import java.util.Set;
import java.util.TreeSet;

/**
 * Level 1 Problem.
 * 
 * @author emmanuel
 * 
 */
public class GoodCompanyDivTwo {
  public int countGood(int[] superior, int[] workType) {
    Set<Integer> work = new TreeSet<>();
    int count = 0;
    for (int i = 0; i < superior.length; i++) {
      boolean isDiverse = true;
      work.clear();
      work.add(workType[i]);
      for (int j = i + 1; j < superior.length; j++) {
        if (superior[j] == i) {
          if (work.contains(workType[j])) {
            isDiverse = false;
            break;
          } else
            work.add(workType[j]);
        }
      }
      if (isDiverse)
        count++;
    }
    return count;
  }
}
