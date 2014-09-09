package srm184.division2;
/**
 * Level 3 problem.
 * 
 * @author emmanuel
 *
 */
public class TeamBuilder {

  public int[] specialLocations(String[] paths) {
    final int n = paths.length;
    int[][] dist = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dist[i][j] = paths[i].charAt(j) - '0';
      }
    }
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (dist[i][j] == 0 && dist[i][k] == 1 && dist[k][j] == 1)
            dist[i][j] = 1;
        }
      }
    }
    int ret1 = 0, ret2 = 0;
    for (int i = 0; i < n; i++) {
      boolean b1 = true, b2 = true;
      for (int j = 0; j < n; j++) {
        if (i == j)
          continue;
        if (dist[i][j] == 0)
          b1 = false;
        if (dist[j][i] == 0)
          b2 = false;
      }
      if (b1)
        ret1++;
      if (b2)
        ret2++;
    }
    return new int[] {ret1, ret2};
  }

}
