package srm629.division1;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Level 1 problem.
 * 
 * @author emmanuel
 * 
 */
public class RectangleCovering {
  int getMin(int holeH, int holeW, int[] boardH, int[] boardW) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(boardH.length, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2, o1);
      }
    });
    for (int i = 0; i < boardW.length; i++) {
      if (boardW[i] > holeH && boardH[i] > holeH)
        pq.add(Math.max(boardW[i], boardH[i]));
      else if (boardW[i] > holeH)
        pq.add(boardH[i]);
      else if (boardH[i] > holeH)
        pq.add(boardW[i]);
    }
    int sum = 0, count = 0;
    while (!pq.isEmpty()) {
      sum += pq.remove();
      count++;
      if (sum >= holeW)
        return count;
    }
    return -1;
  }

  public int minimumNumber(int holeH, int holeW, int[] boardH, int[] boardW) {
    int ret1 = getMin(holeH, holeW, boardH, boardW);
    int ret2 = getMin(holeW, holeH, boardH, boardW);
    if (ret1 != -1 && ret2 != -1)
      return Math.min(ret1, ret2);
    else if (ret1 != -1)
      return ret1;
    else if (ret2 != -1)
      return ret2;
    return -1;
  }
}
