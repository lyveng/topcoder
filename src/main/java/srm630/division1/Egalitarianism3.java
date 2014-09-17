package srm630.division1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Level1 problem.
 * 
 * @author emmanuel
 * 
 */
public class Egalitarianism3 {

  public int maxCities(int n, int[] a, int[] b, int[] len) {
    int[][] d = new int[n][n];
    for (int i = 0; i < d.length; i++) {
      Arrays.fill(d[i], Integer.MAX_VALUE);
    }
    for (int i = 0; i < a.length; i++) {
      d[a[i] - 1][b[i] - 1] = len[i];
      d[b[i] - 1][a[i] - 1] = len[i];
    }
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (d[i][k] != Integer.MAX_VALUE && d[k][j] != Integer.MAX_VALUE) {
            d[i][j] = Math.min(d[i][k] + d[k][j], d[i][j]);
            d[j][i] = d[i][j];
          }
        }
      }
    }
    int ret = n > 1 ? 2 : 1;
    for (int c = 0; c < n; c++) {
      Map<Integer, List<Integer>> map = new HashMap<>();
      for (int i = 0; i < n; i++) {
        if (c != i) {
          if (!map.containsKey(d[c][i]))
            map.put(d[c][i], new ArrayList<Integer>());
          map.get(d[c][i]).add(i);
        }
      }
      for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
        if (entry.getValue().size() <= ret)
          continue;
        List<Integer> added = new ArrayList<>();
        List<Integer> curSet = entry.getValue();
        for (Integer cur : curSet) {
          boolean good = true;
          for (Integer city : added) {
            good = good && (d[cur][city] == 2 * d[c][city]);
          }
          if (good)
            added.add(cur);
        }
        ret = Math.max(added.size(), ret);
      }
    }
    return ret;
  }

}
