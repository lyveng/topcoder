package srm146.division2;

import java.util.TreeSet;

/**
 * Level 3 Problem.
 * 
 * @author emmanuel
 * 
 */
public class BridgeCrossing {
  private int minTimeConsumed = Integer.MAX_VALUE;

  public int minTime(int[] times) {
    minTimeConsumed = Integer.MAX_VALUE;
    if (times.length == 0)
      return 0;
    if (times.length == 1)
      return times[0];
    minTime(times, new TreeSet<PeopleTimeEntry>(), 0);
    return this.minTimeConsumed;
  }

  private void minTime(int[] times, TreeSet<PeopleTimeEntry> peopleOnLeft, int timeConsumed) {
    if (timeConsumed > minTimeConsumed || peopleOnLeft.size() == times.length)
      return;
    int upTime, downTime;
    PeopleTimeEntry iEntry, jEntry, retEntry;
    for (int i = 0; i < times.length; i++) {
      iEntry = new PeopleTimeEntry(i, times[i]);
      if (peopleOnLeft.contains(iEntry))
        continue;
      for (int j = i + 1; j < times.length; j++) {
        jEntry = new PeopleTimeEntry(j, times[j]);
        if (peopleOnLeft.contains(jEntry))
          continue;
        upTime = times[i] > times[j] ? times[i] : times[j];
        peopleOnLeft.add(iEntry);
        peopleOnLeft.add(jEntry);

        if (peopleOnLeft.size() == times.length && (timeConsumed + upTime) < this.minTimeConsumed)
          minTimeConsumed = timeConsumed + upTime;

        retEntry = peopleOnLeft.first();
        downTime = retEntry.time;
        peopleOnLeft.remove(retEntry);
        minTime(times, peopleOnLeft, timeConsumed + upTime + downTime);
        peopleOnLeft.add(retEntry);
        peopleOnLeft.remove(iEntry);
        peopleOnLeft.remove(jEntry);
      }
    }
  }

  private static class PeopleTimeEntry implements Comparable<PeopleTimeEntry> {
    Integer index, time;

    public PeopleTimeEntry(int index, int time) {
      super();
      this.index = index;
      this.time = time;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + index;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      PeopleTimeEntry other = (PeopleTimeEntry) obj;
      if (index != other.index)
        return false;
      return true;
    }

    @Override
    public int compareTo(PeopleTimeEntry o) {
      return this.time.compareTo(o.time);
    }

    @Override
    public String toString() {
      return index + " ";
    }
  }

  public static void main(String[] args) {
    BridgeCrossing obj = new BridgeCrossing();
    System.out.println(obj.minTime(new int[] {1, 2, 5, 10}));
  }
}
