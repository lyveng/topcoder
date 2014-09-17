package srm217.division1;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Level 1 problem.
 * 
 * @author emmanuel
 *
 */
public class PlayGame {

  public int saveCreatures(int[] you, int[] computer) {
    TreeMap<Integer, Integer> comSet = new TreeMap<>();
    for (int i = 0; i < computer.length; i++) {
      if (!comSet.containsKey(computer[i]))
        comSet.put(computer[i], 0);
      comSet.put(computer[i], comSet.get(computer[i]) + 1);
    }
    Arrays.sort(you);
    int sum = 0;
    for (int i = you.length-1; i >= 0; i--) {
      Entry<Integer, Integer> entry = comSet.floorEntry(you[i] - 1);
      if (entry == null)
        break;
      sum += you[i];
      if (entry.getValue() == 1)
        comSet.remove(entry.getKey());
      else
        comSet.put(entry.getKey(), entry.getValue() - 1);
    }
    return sum;
  }

}
