package srm222.division1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Level 1 problem.
 * 
 * @author emmanuel
 *
 */
public class GroceryBagger {

  public int minimumBags(int strength, String[] itemType) {
    if (strength == 1)
      return itemType.length;
    Arrays.sort(itemType);
    Map<String, Integer> map = new HashMap<>();
    for (String s : itemType) {
      if (!map.containsKey(s)) {
        map.put(s, 0);
      }
      map.put(s, map.get(s) + 1);
    }
    int count = 0;
    for (String string : map.keySet()) {
      count += (map.get(string) / strength);
      if (map.get(string) % strength != 0)
        count++;
    }
    return count;
  }

}
