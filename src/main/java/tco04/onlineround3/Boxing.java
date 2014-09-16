package tco04.onlineround3;
import java.util.TreeSet;

/**
 * Level 1 problem.
 * 
 * @author emmanuel
 *
 */
public class Boxing {

  public int maxCredit(int[] a, int[] b, int[] c, int[] d, int[] e) {
    int[][] arr = {a,b,c,d,e};
    int[] i = {0,0,0,0,0};
    int count = 0;
    while (true) {
      TreeSet<Entry> set = new TreeSet<>();
      for (int j = 0; j < i.length; j++) {
        if (i[j] < arr[j].length) {
          set.add(new Entry(arr[j][i[j]], j));
        }
      }
      if (set.size() < 3)
        return count;
      else if (set.size() > 3)
        while (set.size() != 3)
          set.remove(set.last());
      if (set.last().time - set.first().time <= 1000) {
        count++;
        for (Entry entry : set) {
          i[entry.index] = i[entry.index] + 1;
        }
        for (int j = 0; j < i.length; j++) {
          while (i[j] < arr[j].length && arr[j][i[j]] <= set.last().time)
            i[j] = i[j] + 1;
        }
      }
      else {
        i[set.first().index] = i[set.first().index] + 1;
      }
    }
  }

  static class Entry implements Comparable<Entry> {
    int time;
    int index;
    public Entry(int time, int index) {
      super();
      this.time = time;
      this.index = index;
    }
    @Override
    public int compareTo(Entry o) {
      if (this.time == o.time)
        return this.index - o.index;
      return this.time - o.time;
    }
    @Override
    public String toString() {
      return "Entry [time=" + time + ", index=" + index + "]";
    }
  }

  public static void main(String[] args) {
    TreeSet<Entry> set = new TreeSet<>();
    set.add(new Entry(1, 0));
    set.add(new Entry(1, 1));
    set.add(new Entry(1, 2));
    System.out.println(set.size());
  }
}
