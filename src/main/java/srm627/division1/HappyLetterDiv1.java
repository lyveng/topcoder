package srm627.division1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

/**
 * Level1 problem.
 * 
 * @author emmanuel
 *
 */
public class HappyLetterDiv1 {

  public String getHappyLetters(String letters) {
    Map<Character, Integer> count = new HashMap<>();
    for (Character c : letters.toCharArray()) {
      if (!count.containsKey(c))
        count.put(c, 0);
      count.put(c, count.get(c) + 1);
    }
    int n = letters.length();
    if (letters.length() % 2 != 0)
      n++;
    List<Character> ret = new ArrayList<>();
    for (Entry<Character, Integer> entry : count.entrySet()) {
      if (entry.getValue() >= n)
        return String.valueOf(entry.getKey());
      ret.add(entry.getKey());
    }

    List<Character> winners = new ArrayList<>();
    for (Character c : ret) {
      Map<Character, Integer> curCount = new HashMap<>(count);
      int cCount = curCount.remove(c);
      PriorityQueue<Count> pq = new PriorityQueue<>();
      for (Entry<Character, Integer> entry : curCount.entrySet()) {
        pq.add(new Count(entry.getKey(), entry.getValue()));
      }
      while (pq.size() > 1) {
        Count c1 = pq.remove();
        Count c2 = pq.remove();
        if (c1.count > 1)
          pq.add(new Count(c1.c, c1.count-1));
        if (c2.count > 1)
          pq.add(new Count(c2.c, c2.count - 1));
      }
      if (pq.isEmpty() || pq.remove().count < cCount)
        winners.add(c);
    }

    Collections.sort(winners);
    StringBuilder sb = new StringBuilder();
    for (Character character : winners) {
      sb.append(character);
    }
    return sb.toString();
  }

  class Count implements Comparable<Count> {
    char c;
    int count;

    Count(char c, int count) {
      super();
      this.c = c;
      this.count = count;
    }

    @Override
    public String toString() {
      return "Count [c=" + c + ", count=" + count + "]";
    }

    @Override
    public int compareTo(Count o) {
      return Integer.compare(o.count, this.count);
    }
  }
}
