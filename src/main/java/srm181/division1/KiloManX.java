package srm181.division1;
import java.util.PriorityQueue;

/**
 * Level 3 problem.
 * 
 * @author emmanuel
 *
 */
public class KiloManX {
  private static final int MAX_WEAPON = 1 << 15;

  public int leastShots(String[] damageChart, int[] bossHealth) {
    boolean[] visited = new boolean[MAX_WEAPON];
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(0, 0));
    final int done = (1 << damageChart.length) - 1;
    while (!pq.isEmpty()) {
      Node cur = pq.remove();
      if (visited[cur.weapons])
        continue;
      visited[cur.weapons] = true;
      if (cur.weapons == done)
        return cur.shots;
      for (int i = 0; i < damageChart.length; i++) {
        if ((cur.weapons & (1 << i)) != 0)
          continue;
        int best = bossHealth[i];
        for (int j = 0; j < damageChart.length; j++) {
          if (i == j || (cur.weapons & (1 << j)) == 0)
            continue;
          if (damageChart[j].charAt(i) != '0') {
            int shots = bossHealth[i] / (damageChart[j].charAt(i) - '0');
            if (bossHealth[i] % (damageChart[j].charAt(i) - '0') != 0)
              shots++;
            best = Math.min(best, shots);
          }
        }
        pq.add(new Node(cur.weapons | (1 << i), cur.shots + best));
      }
    }
    return 0;
  }

  class Node implements Comparable<Node> {
    int weapons, shots;

    Node(int weapons, int shots) {
      super();
      this.weapons = weapons;
      this.shots = shots;
    }

    @Override
    public int compareTo(Node o) {
      return this.shots - o.shots;
    }
  }
}
