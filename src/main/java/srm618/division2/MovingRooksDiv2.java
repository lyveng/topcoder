package srm618.division2;

/**
 * Level 3 problem.
 * 
 * @author emmanuel
 *
 */
public class MovingRooksDiv2 {
  final int MAX_ENC_VALUE = 1 << 24;
  final int MAX_QUEUE_LENTH = 40321;
  final int RADIX = 8;
  boolean[] visited = new boolean[MAX_ENC_VALUE];
  int[] q = new int[MAX_QUEUE_LENTH];

  public String move(int[] Y1, int[] Y2) {
    int start = getEncValue(Y1);
    int end = getEncValue(Y2);
    int qFront = 0, qEnd = 0;
    q[qEnd++] = start;
    StringBuilder nextSb = new StringBuilder(8);
    visited[start] = true;
    found:
    while (qFront != qEnd) {
      int cur = q[qFront++], next;
      String curStr = String.format("%08o", cur), nextStr;
      for (int i = RADIX - Y2.length; i < RADIX; i++) {
        for (int j = i+1; j < RADIX; j++) {
          if (curStr.charAt(i) > curStr.charAt(j))
          {
            nextSb.setLength(0);
            nextSb.append(curStr);
            char tmp = nextSb.charAt(i);
            nextSb.setCharAt(i, nextSb.charAt(j));
            nextSb.setCharAt(j, tmp);
            nextStr = nextSb.toString();
            next = getEncValue(nextStr);
            if (!visited[next]) {
              visited[next] = true;
              q[qEnd++] = next;
              if (next == end)
                break found;
            }
          }
        }
      }
    }
    if (visited[end])
      return "Possible";
    else
      return "Impossible";
  }

  private String getString(int[] a) {
    StringBuilder sb = new StringBuilder();
    for (int i : a) {
      sb.append(i);
    }
    return sb.toString();
  }

  private int getEncValue(int[] a) {
    return Integer.parseInt(getString(a), RADIX);
  }

  private int getEncValue(String a) {
    return Integer.parseInt(a, RADIX);
  }
}
