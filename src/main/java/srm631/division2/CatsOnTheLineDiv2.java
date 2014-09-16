package srm631.division2;
import java.util.Arrays;

/**
 * Level 2 problem.
 * 
 * @author emmanuel
 *
 */
public class CatsOnTheLineDiv2 {

  public String getAnswer(int[] position, int[] count, int time) {
    Entry[] entries = new Entry[position.length];
    for (int i = 0; i < entries.length; i++) {
      entries[i] = new Entry(position[i], count[i]);
    }
    Arrays.sort(entries);

    int prevRight = -2001, left, right;
    for (int i = 0; i < entries.length; i++) {
      Entry entry = entries[i];
      if (entry.count > 2 * time + 1)
        return "Impossible";
      left = entry.pos - time;
      if (left <= prevRight)
        left = prevRight + 1;
      right = left + entry.count - 1;
      if (right > entry.pos + time)
        return "Impossible";
      prevRight = right;
    }

    return "Possible";
  }

  class Entry implements Comparable<Entry> {
    int pos, count;

    Entry(int pos, int count) {
      super();
      this.pos = pos;
      this.count = count;
    }

    @Override
    public int compareTo(Entry o) {
      return this.pos - o.pos;
    }

    @Override
    public String toString() {
      return "Entry [pos=" + pos + ", count=" + count + "]";
    }
  }
  
}
